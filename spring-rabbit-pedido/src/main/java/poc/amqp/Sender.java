package poc.amqp;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import poc.entity.Pedido;

@Component
public class Sender extends AbstractRabbitUser {

	public void send(Pedido p) throws IOException {
    	Gson gson = new Gson();
        String message = gson.toJson(p);
        getChannel().basicPublish("", QUEUE_PEDIDOS, null, message.getBytes());
    }
}
