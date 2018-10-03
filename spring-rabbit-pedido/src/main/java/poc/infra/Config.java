package poc.infra;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.*;

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
    public Object receiver() {
        return new Object();
    }

    @Bean
    public Sender sender() {
        return new Sender();
    }
}