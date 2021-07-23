package br.com.zupacademy.charles.transacao.repository;

import br.com.zupacademy.charles.transacao.model.Transacoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, String> {

    @Query("SELECT f FROM Transacoes f WHERE f.cartao.id = :idCartao")
    Page<Transacoes> findByTransacoesCartao(String idCartao, Pageable paginacao);
}
