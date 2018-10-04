package poc.amqp;

import java.io.IOException;
import java.util.Date;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import poc.entity.Pedido;

public class MessageProcessor extends DefaultConsumer{

	private Sender sender;

	public MessageProcessor(Channel channel, Sender sender) {
		super(channel);
		this.sender = sender;
	}
	
	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
			throws IOException {
		System.out.println(String.format("consumerTag=%s, \nenvelope=%s, \nproperties=%s, \nbody=%s", consumerTag, envelope, properties, new String(body)));
		Gson gson = new Gson();
		Pedido p = gson.fromJson(new String(body), Pedido.class);
		simulaUmProcessamento();
		confirmaEntrefa(p);
	}

	private void confirmaEntrefa(Pedido p) {
		try {
			p.setDataProocessamento(new Date());
			sender.send(p);
			System.out.println(">>> Entrega confirmada!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void simulaUmProcessamento() {
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
	}

}