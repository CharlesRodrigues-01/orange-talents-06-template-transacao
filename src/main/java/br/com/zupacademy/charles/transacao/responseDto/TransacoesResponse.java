package br.com.zupacademy.charles.transacao.responseDto;

import br.com.zupacademy.charles.transacao.model.Cartao;
import br.com.zupacademy.charles.transacao.model.Estabelecimento;
import br.com.zupacademy.charles.transacao.model.Transacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacoesResponse {

    private String id;
    private BigDecimal valor;
    private Estabelecimento estabelecimento;
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacoesResponse(){}

    public TransacoesResponse(String id, BigDecimal valor, Estabelecimento estabelecimento,
                              Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacoes toModel() {
        return new Transacoes(this.id, this.valor, this.estabelecimento, this.cartao, this.efetivadaEm);
    }
}
