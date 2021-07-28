package br.com.zupacademy.valteir.transacao.consultar_transacoes_recentes;

import br.com.zupacademy.valteir.transacao.consumir_transacoes.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private LocalDateTime efetivadaEm;
    private BigDecimal valor;
    private String estabelecimento;

    public TransacaoResponse(Transacao transacao) {
        this.efetivadaEm = transacao.getEfetivadaEm();
        this.valor = transacao.getValor();
        this.estabelecimento = transacao.getEstabelecimento();
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }
}
