package br.com.zupacademy.charles.transacao.repository;

import br.com.zupacademy.charles.transacao.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
