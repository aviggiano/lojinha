package main.java.br.com.airu;

import java.util.ArrayList;
import java.util.List;

public class Produto {

	public static final int COMUM = 0;
	public static final int MANUFATURADO = 1;
	public static final int IMPORTADO = 2;
	/* do enunciado, entende-se que um produto perecivel e' um produto comum com
	 * valor de frete = 10 * valor de frete comum
	 */
	public static final int PERECIVEL = 3;
	
	private final String titulo;
	private final int preco;
	private int tipo;
	private List<Integer> prazo;
	private List<Integer> frete;
	private List<Double> taxaExtra;
	
	public Produto(final String titulo, final int preco, final int tipo) {
		this.titulo = titulo;
		this.preco = preco;
		this.tipo = tipo;
		calculaPrazo();
		calculaFrete();
		calculaTaxaExtra();
	}
	
	private void calculaTaxaExtra() {
		taxaExtra = new ArrayList<Double>();
		taxaExtra.add(COMUM, 1.0);
		taxaExtra.add(MANUFATURADO, 1.0);
		taxaExtra.add(IMPORTADO, 1.5);
		taxaExtra.add(PERECIVEL, 1.0);
	}

	private void calculaPrazo() {
		prazo = new ArrayList<Integer>();
		prazo.add(COMUM, 3);
		prazo.add(MANUFATURADO, 5);
		prazo.add(IMPORTADO, 15);
		prazo.add(PERECIVEL, 3);
	}

	private void calculaFrete() {
		frete = new ArrayList<Integer>();
		frete.add(COMUM, 10);
		frete.add(MANUFATURADO, 10);
		frete.add(IMPORTADO, 20);
		frete.add(PERECIVEL, 10 * frete.get(COMUM));
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
		return prazo.get(tipo);
	}
	
	public int getFrete() {
		return frete.get(tipo);
	}
	
	public double getTaxaExtra() {
		return taxaExtra.get(tipo);
	}

}
