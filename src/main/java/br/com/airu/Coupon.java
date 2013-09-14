package main.java.br.com.airu;

public class Coupon {
	/* Aqui e' admitido que os atributos dos coupons sao imutaveis. Nao e' possivel alterar o codigo 
	 * nem o desconto nem o valor minimo de compra, uma vez que o Coupon e' gerado. 
	 * Essa decisao depende das regras de negocio do sistema da lojinha.  
	 */
	private final String codigo;
	private final double desconto;
	private final int valorMinimoCompra;
	
	public Coupon (String codigo, double desconto, int valorMinimoCompra) {
		this.codigo = codigo;
		this.desconto = desconto;
		this.valorMinimoCompra = valorMinimoCompra;
	}

	public String getCodigo() {
		return codigo;
	}
	
	
}
