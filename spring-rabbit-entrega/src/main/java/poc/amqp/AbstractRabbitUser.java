package poc.amqp;

import org.springframework.beans.factory.annotation.Value;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class AbstractRabbitUser {

	public static final String QUEUE_PEDIDOS = "pedidos";
	public static final String QUEUE_ENTREGAS = "entregas";
	
	private Channel channel;
	private Connection connection;

	@Value("${rabbitmq.host}")
	private String host;

	@Value("${rabbitmq.port}")
	private int port;

	@Value("${rabbitmq.username}")
	private String usr;

	@Value("${rabbitmq.password}")
	private String pwd;

	private void open() throws Exception {
		if (channel == null) {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost(host);
			factory.setPort(port);
			factory.setUsername(usr);
			factory.setPassword(pwd);
			connection = factory.newConnection();
			channel = connection.createChannel();
		}
	}

	public Channel getChannel() {
		try {
			open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return channel;
	}

	void reset() throws Exception {
		if (channel != null) {
			channel.close();
			connection.close();
		}
	}
}
