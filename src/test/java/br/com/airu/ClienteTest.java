package test.java.br.com.airu;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import main.java.br.com.airu.*;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void testCheckout() {
		Cliente zacarias = new Cliente("Zacarias");
		
		Produto caixa = new Produto("caixa de milho", 1000, Produto.COMUM);
		Produto boneca = new Produto("boneca", 3000, Produto.MANUFATURADO);
		Produto relogio = new Produto("relógio", 6000, Produto.IMPORTADO);
		
		Pedido pedido1 = new Pedido(caixa, 2);
		Pedido pedido2 = new Pedido(boneca, 1);
		Pedido pedido3 = new Pedido(relogio, 1);
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(pedido1);
		pedidos.add(pedido2);
		pedidos.add(pedido3);
		
		Compra compra = new Compra(zacarias, pedidos);
		
		assertEquals("Pedido para Zacarias\n" +
					 "Valor total: 14000\n" +
					 "Valor frete: 40\n" +
					 "Prazo de entrega: 15 dias\n", compra.checkout());
	}

}
