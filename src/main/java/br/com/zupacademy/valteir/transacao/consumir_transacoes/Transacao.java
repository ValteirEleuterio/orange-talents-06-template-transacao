package br.com.zupacademy.valteir.transacao.consumir_transacoes;

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

    @Deprecated
    private Transacao() {}

    public Transacao(BigDecimal valor, LocalDateTime efetivadaEm, String cartao, String estabelecimento) {
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }
}
