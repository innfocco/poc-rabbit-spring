package poc.amqp;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver extends AbstractRabbitUser {
	
	boolean autoAck = true;
	
	@Autowired
	Sender sender;
	
	public void receive() throws IOException {
		getChannel().basicConsume(QUEUE_PEDIDOS, autoAck, "entregaSys", new MessageProcessor(getChannel(), sender));
	}

}
