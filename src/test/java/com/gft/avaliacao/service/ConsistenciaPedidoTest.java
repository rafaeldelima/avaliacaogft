package com.gft.avaliacao.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gft.avaliacao.commons.Prato;
import com.gft.avaliacao.commons.TipoPrato;

/**
 * Classe responsavel por realizar os testes da classe ConsistenciaPedido
 * @author rafab
 *
 */
public class ConsistenciaPedidoTest {

	@Test
	public void validarDadosEntradaPedido(){
		String entradaCorreta = "manha, 2";
		ConsistenciaPedido consistencia = new ConsistenciaPedido();
		assertEquals(false, consistencia.validarDadosEntradaPedido(entradaCorreta));
	}
	
	@Test
	public void validarDadosEntradaPedidoComErro(){
		String entradaCorreta = "tarde, 1,2,2";
		ConsistenciaPedido consistencia = new ConsistenciaPedido();
		assertEquals(true, consistencia.validarDadosEntradaPedido(entradaCorreta));
		
	}
	
	@Test
	public void validarDadosEntradaPedidoIncompleto(){
		String entradaCorreta = "tarde";
		ConsistenciaPedido consistencia = new ConsistenciaPedido();
		assertEquals(true, consistencia.validarDadosEntradaPedido(entradaCorreta));		
	}
	
	@Test
	public void validarRegrasPedidoComQuantidadeMaiorQueHum(){
		Prato prato = new Prato("teste prato", TipoPrato.ENTRADA, true, 2);
		ConsistenciaPedido consistencia = new ConsistenciaPedido();
		assertEquals(false, consistencia.validarRegrasPedido(prato));		
	}
	
	@Test
	public void validarRegrasPedidoComQuantidadeIgualHum(){
		Prato prato = new Prato("teste prato", TipoPrato.ENTRADA, true, 1);
		ConsistenciaPedido consistencia = new ConsistenciaPedido();
		assertEquals(false, consistencia.validarRegrasPedido(prato));		
	}
	
	@Test
	public void validarRegrasPedidoIncorreto(){
		Prato prato = new Prato("teste prato", TipoPrato.ENTRADA, false, 2);
		ConsistenciaPedido consistencia = new ConsistenciaPedido();
		assertEquals(true, consistencia.validarRegrasPedido(prato));		
	}
	
}
