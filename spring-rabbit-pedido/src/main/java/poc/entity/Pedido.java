package poc.entity;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 4036371136883630447L;
	private String id;
	private String item;
	private int quantidade;
	private Date dataPedido = new Date();
	private Date dataProocessamento;

	public Pedido() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public Date getDataProocessamento() {
		return dataProocessamento;
	}

	public void setDataProocessamento(Date dataProocessamento) {
		this.dataProocessamento = dataProocessamento;
	}

}
