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
	private MapaDeTipos mapaDeTipos;
	
	public Produto(final String titulo, final int preco, final int tipo) {
		this.titulo = titulo;
		this.preco = preco;
		this.tipo = tipo;
		this.mapaDeTipos = new MapaDeTipos();
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
		return mapaDeTipos.getPrazo(tipo);
	}
	
	public int getFrete() {
		return mapaDeTipos.getFrete(tipo);
	}
	
	public double getTaxaExtra() {
		return mapaDeTipos.getTaxaExtra(tipo);
	}

}
