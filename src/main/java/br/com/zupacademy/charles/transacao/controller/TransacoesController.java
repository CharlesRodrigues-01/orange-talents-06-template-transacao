package br.com.zupacademy.charles.transacao.controller;

import br.com.zupacademy.charles.transacao.model.Cartao;
import br.com.zupacademy.charles.transacao.model.Transacoes;
import br.com.zupacademy.charles.transacao.repository.CartaoRepository;
import br.com.zupacademy.charles.transacao.repository.TransacoesRepository;
import br.com.zupacademy.charles.transacao.responseDto.TransacoesViewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

    CartaoRepository cartaoRepository;
    TransacoesRepository transacoesRepository;

    public TransacoesController(CartaoRepository cartaoRepository,
                                TransacoesRepository transacoesRepository) {
        this.cartaoRepository = cartaoRepository;
        this.transacoesRepository = transacoesRepository;
    }

    @GetMapping("/cartao/{id}")
    public ResponseEntity<Page<?>> buscarTransacoes(@PathVariable("id") String idCartao,
                                       @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC,
                                               page = 0, size = 10) Pageable paginacao){

        Optional<Cartao> cartao = cartaoRepository.findById(idCartao);
        Page<Transacoes> transacoesPorCartao = transacoesRepository.findByTransacoesCartao(idCartao, paginacao);

        if (cartao.isPresent()) {
            return ResponseEntity.ok().body(TransacoesViewDto.converter(transacoesPorCartao));
        }
        return ResponseEntity.notFound().build();
    }
}
