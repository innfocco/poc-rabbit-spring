package poc.ctrl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import poc.entity.Pedido;
import poc.infra.Routes;
import poc.svc.PedidoService;

@RestController
@RequestMapping(Routes.PEDIDO_BASE_PATH)
public class PedidoController {

	@Autowired
	private PedidoService svc;
	
	@PostMapping
	public void recebePedido(@RequestBody Pedido p) {
		p.setId(UUID.randomUUID().toString());
		svc.receive(p);
	}
	
	@GetMapping
	public Pedido consultaPedido(String id) {
		return svc.get(id);
	}

}
