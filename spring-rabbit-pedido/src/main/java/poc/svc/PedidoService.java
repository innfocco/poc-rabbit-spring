package poc.svc;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.amqp.Sender;
import poc.entity.Pedido;

@Service
public class PedidoService {

	private static final HashMap<String, Pedido> pedidosMap = new HashMap<>();
	
	@Autowired
	private Sender sender;
	
	public void receive(Pedido p) {
		pedidosMap.put(p.getId(), p);
		try {
			sender.send(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Pedido get(String id) {
		return pedidosMap.get(id);
	}
}
