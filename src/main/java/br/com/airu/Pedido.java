package main.java.br.com.airu;

public class Pedido {

	private final Produto produto;
	private final int quantidade;
	private Coupon coupon;

	public Pedido(final Produto produto, final int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
}
