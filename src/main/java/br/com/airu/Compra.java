package main.java.br.com.airu;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	private final Cliente cliente;
	private List<Pedido> pedidos;
	private Coupon coupon;

	public Compra (final Cliente cliente, List<Pedido> pedidos) {
		this.cliente = cliente;
		this.pedidos = pedidos;
	}
	
	public void addPedido(final Pedido pedido) {
		pedidos.add(pedido);
	}

	public String checkout() {
		int total = 0;
		int prazo = 0;
		int frete = 0;
		String result = "Pedido para " + cliente.getName() + "\n";
		for (final Pedido pedido : pedidos) {
				total += pedido.getProduto().getPreco() * pedido.getQuantidade() * pedido.getProduto().getTaxaExtra();
				prazo = prazo < pedido.getProduto().getPrazo() ? pedido.getProduto().getPrazo() : prazo;
				frete += pedido.getProduto().getFrete();
		}
		result += "Valor total: " + total + "\n";
		result += "Valor frete: " + frete + "\n";
		result += "Prazo de entrega: " + prazo + " dias\n";
		/* Aqui o valor do coupon nao e' subtraido do valor final. Seria simples de alterar o valor total como
		 * total = subtotal - desconto, mas o enunciado do problema nao deixa claro se isso deve ser feito ou nao.
		 */
		result += (coupon != null && total > coupon.getValorMinimoCompra())? "Desconto: " + coupon.getDesconto() + "\n" : "";
		return result;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

}
