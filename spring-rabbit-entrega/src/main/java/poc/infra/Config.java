package poc.infra;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import poc.amqp.Receiver;
import poc.amqp.Sender;

@Configuration
public class Config {

    @Bean
    public Queue pedidos() {
        return new Queue("pedidos");
    }
    
    @Bean
    public Queue entregas() {
        return new Queue("entregas");
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

    @Bean
    public Sender sender() {
        return new Sender();
    }
}