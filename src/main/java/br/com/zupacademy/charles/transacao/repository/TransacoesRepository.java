package br.com.zupacademy.charles.transacao.repository;

import br.com.zupacademy.charles.transacao.model.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, String> {
}
