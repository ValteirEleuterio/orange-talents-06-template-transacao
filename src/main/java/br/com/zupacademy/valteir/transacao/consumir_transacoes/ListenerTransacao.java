package br.com.zupacademy.valteir.transacao.consumir_transacoes;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Component
public class ListenerTransacao {

    private final EntityManager manager;

    public ListenerTransacao(EntityManager manager) {
        this.manager = manager;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(TransacaoDto transacaoDto) {
        System.out.println(transacaoDto.getCartao().getEmail());
        var transacao = transacaoDto.toModel();
        manager.persist(transacao);
    }

}