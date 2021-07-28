package br.com.zupacademy.valteir.transacao.consometransacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDto {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoDto estabelecimento;
    private CartaoDto cartao;
    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDto getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDto getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(valor, efetivadaEm, cartao.getId(), estabelecimento.getNome());
    }
}
