package br.com.zupacademy.valteir.transacao.consultar_transacoes_recentes;

import br.com.zupacademy.valteir.transacao.consumir_transacoes.Transacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.stream.Collectors;

@RestController
public class ConsultarTransacoesRecentesController {

    private EntityManager manager;

    public ConsultarTransacoesRecentesController(EntityManager manager) {
        this.manager = manager;
    }

    @GetMapping("/cartoes/{id}/transacoes")
    public ResponseEntity<?> consultar(@PathVariable("id") String idCartao) {

        var sql = "select t from Transacao t where t.cartao = :pCartao order by t.efetivadaEm desc";
        var query = manager.createQuery(sql, Transacao.class);
        query.setParameter("pCartao", idCartao);
        var resultList = query.setMaxResults(10).getResultList();

        if(resultList.isEmpty())
            return ResponseEntity.notFound().build();

        var resultado = resultList.stream()
                .map(TransacaoResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resultado);
    }
}
