package main.java.br.com.airu;

import java.util.ArrayList;
import java.util.List;

/* Essa classe tenta reduzir a carga da classe Pedido. Anteriormente, Pedido continha a taxa etra, o prazo
 * de entrega e o frete de todos os tipos de produtos. Se pensarmos em uma instancia de produto, e' normal que
 * ela tenha apenas o prazo, taxa e frete referentes 'aquele tipo.
 * As listas de prazo, frete e taxa de entrega servem para deixar o codigo mais leve. Todavia, poderiamos 
 * ter utilizado valores 'final' assim como foi feito para os tipos de produto (COMUM, MANUFATURADO, IMPORTADO, etc.)  
 */

public class MapaDeTipos {
	
	private static List<Integer> prazo;
	private static List<Integer> frete;
	private static List<Double> taxaExtra;
	
	public MapaDeTipos () {
		 calculaTaxaExtra();
		 calculaPrazo();
		 calculaFrete();
	}

	private void calculaTaxaExtra() {
		taxaExtra = new ArrayList<Double>();
		taxaExtra.add(Produto.COMUM, 1.0);
		taxaExtra.add(Produto.MANUFATURADO, 1.0);
		taxaExtra.add(Produto.IMPORTADO, 1.5);
		taxaExtra.add(Produto.PERECIVEL, 1.0);
	}

	private void calculaPrazo() {
		prazo = new ArrayList<Integer>();
		prazo.add(Produto.COMUM, 3);
		prazo.add(Produto.MANUFATURADO, 5);
		prazo.add(Produto.IMPORTADO, 15);
		prazo.add(Produto.PERECIVEL, 3);
	}

	private void calculaFrete() {
		frete = new ArrayList<Integer>();
		frete.add(Produto.COMUM, 10);
		frete.add(Produto.MANUFATURADO, 10);
		frete.add(Produto.IMPORTADO, 20);
		frete.add(Produto.PERECIVEL, 10 * frete.get(Produto.COMUM));
	}

	public double getTaxaExtra(int tipo) {
		return taxaExtra.get(tipo);
	}
	
	public int getPrazo(int tipo) {
		return prazo.get(tipo);
	}
	
	public int getFrete(int tipo) {
		return frete.get(tipo);
	}
}
