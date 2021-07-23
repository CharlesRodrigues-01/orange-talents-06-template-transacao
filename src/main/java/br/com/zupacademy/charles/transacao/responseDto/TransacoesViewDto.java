package br.com.zupacademy.charles.transacao.responseDto;

import br.com.zupacademy.charles.transacao.model.Cartao;
import br.com.zupacademy.charles.transacao.model.Estabelecimento;
import br.com.zupacademy.charles.transacao.model.Transacoes;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacoesViewDto {

    private String id;
    private BigDecimal valor;
    private Estabelecimento estabelecimento;
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    public TransacoesViewDto(Transacoes transacoes) {
        this.id = transacoes.getId();
        this.valor = transacoes.getValor();
        this.estabelecimento = transacoes.getEstabelecimento();
        this.cartao = transacoes.getCartao();
        this.efetivadaEm = transacoes.getEfetivadaEm();
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

    public static Page<TransacoesViewDto> converter(Page<Transacoes> transacoes) {
        return transacoes.map(TransacoesViewDto::new);
    }

}
