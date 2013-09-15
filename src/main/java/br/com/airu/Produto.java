package main.java.br.com.airu;

public class Produto {

	public static final int COMUM = 0;
	public static final int MANUFATURADO = 1;
	public static final int IMPORTADO = 2;
	
	/* valores necessarios para fazer o checkout de um produto */
	public static final int PRAZO_COMUM = 3;
	public static final int PRAZO_MANUFATURADO = 5;
	public static final int PRAZO_IMPORTADO = 15;
	
	public static final int FRETE_COMUM = 10;
	public static final int FRETE_MANUFATURADO = 10;
	public static final int FRETE_IMPORTADO = 20;
	
	public static final double TAXA_EXTRA_COMUM = 1;
	public static final double TAXA_EXTRA_MANUFATURADO = 1;
	public static final double TAXA_EXTRA_IMPORTADO = 1.5;
	
	private final String titulo;
	private final int preco;
	private int tipo;
	private int prazo;
	private int frete;
	private double taxaExtra;
	
	public Produto(final String titulo, final int preco, final int tipo) {
		this.titulo = titulo;
		this.preco = preco;
		this.tipo = tipo;
		calculaPrazoMin();
		calculaFrete();
		calculaTaxaExtra();
	}
	
	private void calculaTaxaExtra() {
		if (this.tipo == COMUM)
			taxaExtra = 1;
		else if (this.tipo == MANUFATURADO)
			taxaExtra = 1;
		else if (this.tipo == IMPORTADO)
			taxaExtra = 1.5;
	}

	private void calculaPrazoMin() {
		if (this.tipo == COMUM)
			prazo = PRAZO_COMUM;
		else if (this.tipo == MANUFATURADO)
			prazo = PRAZO_MANUFATURADO;
		else if (this.tipo == IMPORTADO)
			prazo = PRAZO_IMPORTADO;
	}

	private void calculaFrete() {
		if (this.tipo == COMUM)
			frete = FRETE_COMUM;
		else if (this.tipo == MANUFATURADO)
			frete = FRETE_MANUFATURADO;
		else if (this.tipo == IMPORTADO)
			frete = FRETE_IMPORTADO;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getPreco() {
		return preco;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(final int tipo) {
		this.tipo = tipo;
	}
	
	public int getPrazo() {
		return prazo;
	}
	
	public int getFrete() {
		return frete;
	}
	
	public double getTaxaExtra() {
		return taxaExtra;
	}

}
