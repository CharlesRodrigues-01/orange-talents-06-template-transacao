package br.com.zupacademy.charles.transacao.kafka;

import br.com.zupacademy.charles.transacao.model.Transacoes;
import br.com.zupacademy.charles.transacao.repository.TransacoesRepository;
import br.com.zupacademy.charles.transacao.responseDto.TransacoesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    TransacoesRepository repository;

    public ListenerDeTransacao(TransacoesRepository repository){
        this.repository = repository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacoesResponse transacoesResponse) {

        logger.info("Salvando na base de dados a transação id: " + transacoesResponse.getId());
        Transacoes transacoes = transacoesResponse.toModel();
        repository.save(transacoes);
        logger.info("Salvo na base de dados");

    }
}
