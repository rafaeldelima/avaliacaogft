package com.gft.avaliacao.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gft.avaliacao.commons.Pedido;

/**
 * Classe responsavel por realizar os testes da classe PedidoService
 * @author rafab
 *
 */
public class PedidoServiceTest {



	@Test
	public void ordemManhaSobremesa() throws Exception{		
		String entrada = "manha, 1, 2, 3, 4";
		String saidaEsperada = "ovos, torrada, cafe, erro de impressao";
		PedidoService cardapioService = new PedidoService();
		Pedido pedido = cardapioService.retornarPedido(entrada);
		String impressaoPedido = PedidoImpressao.imprimirPedido(pedido);
		assertEquals(saidaEsperada, impressaoPedido);
		
	}
	
	@Test
	public void ordemManhaCompleta() throws Exception{		
		String entrada = "manha, 1, 2, 3";
		String saidaEsperada = "ovos, torrada, cafe";
		PedidoService cardapioService = new PedidoService();
		Pedido pedido = cardapioService.retornarPedido(entrada);
		String impressaoPedido = PedidoImpressao.imprimirPedido(pedido);
		
		assertEquals(saidaEsperada, impressaoPedido);
		
	}
	
	@Test
	public void OrdemManhaInvertida() throws Exception{		
		String entrada = "manha, 2, 1, 3";
		String saidaEsperada = "ovos, torrada, cafe";
		PedidoService cardapioService = new PedidoService();
		Pedido pedido = cardapioService.retornarPedido(entrada);
		String impressaoPedido = PedidoImpressao.imprimirPedido(pedido);
		
		assertEquals(saidaEsperada, impressaoPedido);
		
	}
	
	
	@Test
	public void ordemManhaTriploCafe() throws Exception{		
		String entrada = "manha, 1, 2, 3, 3, 3";
		String saidaEsperada = "ovos, torrada, cafe(x3)";
		PedidoService cardapioService = new PedidoService();
		Pedido pedido = cardapioService.retornarPedido(entrada);
		String impressaoPedido = PedidoImpressao.imprimirPedido(pedido);

		assertEquals(saidaEsperada, impressaoPedido);
		
	}
	
	@Test
	public void ordemNoiteCompleta() throws Exception{		
		String entrada = "noite, 1, 2, 3, 4";
		String saidaEsperada = "bife, batata, vinho, bolo";
		PedidoService cardapioService = new PedidoService();
		Pedido pedido = cardapioService.retornarPedido(entrada);
		String impressaoPedido = PedidoImpressao.imprimirPedido(pedido);
		
		assertEquals(saidaEsperada, impressaoPedido);
		
	}
	
	@Test
	public void ordemNoiteDuplaBatata() throws Exception{		
		String entrada = "noite, 1, 2, 2, 4";
		String saidaEsperada = "bife, batata(x2), bolo";
		PedidoService cardapioService = new PedidoService();
		Pedido pedido = cardapioService.retornarPedido(entrada);
		String impressaoPedido = PedidoImpressao.imprimirPedido(pedido);
		
		assertEquals(saidaEsperada, impressaoPedido);
		
	}
	
	@Test
	public void ordemSemPeriodoInformado() throws Exception{		
		String entrada = " 1, 2, 2, 4";
		String saidaEsperada = "erro de impressao";
		PedidoService cardapioService = new PedidoService();
		Pedido pedido = cardapioService.retornarPedido(entrada);
		String impressaoPedido = PedidoImpressao.imprimirPedido(pedido);
		
		assertEquals(saidaEsperada, impressaoPedido);
		
	}
	
	@Test
	public void ordemSemItensInformados() throws Exception{		
		String entrada = "noite";
		String saidaEsperada = "erro de impressao";
		PedidoService cardapioService = new PedidoService();
		Pedido pedido = cardapioService.retornarPedido(entrada);
		String impressaoPedido = PedidoImpressao.imprimirPedido(pedido);
		
		assertEquals(saidaEsperada, impressaoPedido);
		
	}
	
	
	
}
