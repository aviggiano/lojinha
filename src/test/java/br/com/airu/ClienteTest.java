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
	
	@Test
	public void testCheckoutComCouponAceito() {
		Cliente mussum = new Cliente("Mussum");
		
		Produto estojo = new Produto("estojo", 1000, Produto.COMUM);
		Produto lapis = new Produto("lapis", 3000, Produto.MANUFATURADO);
		Produto tenis = new Produto("tenis", 6000, Produto.IMPORTADO);
		
		Pedido pedido1 = new Pedido(estojo, 2);
		Pedido pedido2 = new Pedido(lapis, 1);
		Pedido pedido3 = new Pedido(tenis, 1);
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(pedido1);
		pedidos.add(pedido2);
		pedidos.add(pedido3);
		
		Coupon coupon = new Coupon("1.4142", 1400, 10000);
		
		Compra compra = new Compra(mussum, pedidos);
		compra.setCoupon(coupon);
		
		assertEquals("Pedido para Mussum\n" +
					 "Valor total: 14000\n" +
					 "Valor frete: 40\n" +
					 "Prazo de entrega: 15 dias\n" +
					 "Desconto: 1400\n", compra.checkout());		
	}
	
	@Test
	public void testCheckoutComCouponNaoAceito() {
		Cliente dede = new Cliente("Dédé");
		
		Produto estojo = new Produto("estojo", 1000, Produto.COMUM);
		Produto lapis = new Produto("lapis", 3000, Produto.MANUFATURADO);
		Produto tenis = new Produto("tenis", 6000, Produto.IMPORTADO);
		
		Pedido pedido1 = new Pedido(estojo, 2);
		Pedido pedido2 = new Pedido(lapis, 1);
		Pedido pedido3 = new Pedido(tenis, 1);
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(pedido1);
		pedidos.add(pedido2);
		pedidos.add(pedido3);
		
		Coupon coupon = new Coupon("3.1415", 1400, 24000);
		
		Compra compra = new Compra(dede, pedidos);
		compra.setCoupon(coupon);
		
		assertEquals("Pedido para Dédé\n" +
					 "Valor total: 14000\n" +
					 "Valor frete: 40\n" +
					 "Prazo de entrega: 15 dias\n", compra.checkout());		
	}

	@Test
	public void testCheckoutPerecivel() {
		Cliente didi = new Cliente("Didi");
		
		Produto ovo = new Produto ("ovo", 100, Produto.PERECIVEL);
		
		Pedido pedido1 = new Pedido(ovo, 1);
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(pedido1);
		
		Compra compra = new Compra(didi, pedidos);
		
		assertEquals("Pedido para Didi\n" +
					 "Valor total: 100\n" +
					 "Valor frete: 100\n" +
					 "Prazo de entrega: 3 dias\n", compra.checkout());				
	}
}
