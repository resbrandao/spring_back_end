package br.com.fiap.spring.connections;

import br.com.fiap.spring.constantes.RabbitMQConstantes;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {

    private static final String NOME_EXCHANGE="amq.direct";

    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String nomeFila) {
        return new Queue(nomeFila, true, false, false);
    }

    private DirectExchange trocaDireta() {
        return  new DirectExchange(NOME_EXCHANGE);
    }

    private Binding relacionamento(Queue fila, DirectExchange troca) {
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
    }

    @PostConstruct
    private void adiciona() {
        Queue filaAgendamento = this.fila(RabbitMQConstantes.FILA_AGENDAMENTO);

        DirectExchange troca = this.trocaDireta();

        Binding ligacaoAgendamento = this.relacionamento(filaAgendamento, troca);

        //Criando as filas no RabbitMQ
        this.amqpAdmin.declareQueue(filaAgendamento);

        //Criando as exchanges
        this.amqpAdmin.declareExchange(troca);

        this.amqpAdmin.declareBinding(ligacaoAgendamento);
    }

}
