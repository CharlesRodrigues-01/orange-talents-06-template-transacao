package br.com.zupacademy.charles.transacao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacoes {

    @Id
    private String id;
    private BigDecimal valor;
    @OneToOne(cascade = CascadeType.MERGE)
    private Estabelecimento estabelecimento;
    @OneToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacoes(){}

    public Transacoes(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
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
}