package br.com.zupacademy.valteir.transacao.consometransacoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private String cartao;
    private String estabelecimento;

    public Transacao(BigDecimal valor, LocalDateTime efetivadaEm, String cartao, String estabelecimento) {
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
    }
}
