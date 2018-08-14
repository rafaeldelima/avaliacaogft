package com.gft.avaliacao.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.gft.avaliacao.commons.Cardapio;
import com.gft.avaliacao.commons.CardapioManha;
import com.gft.avaliacao.commons.CardapioNoite;
import com.gft.avaliacao.commons.Pedido;
import com.gft.avaliacao.commons.Prato;
import com.gft.avaliacao.helper.PedidoHelper;

/**
 * Classe responsavel por realizar as regras para criacao do pedido
 * @author rafab
 *
 */
public class PedidoService {

	/**
	 * Lista de cardapios disponiveis
	 */
	private final List<Cardapio> cardapios = Arrays.asList(
			new CardapioManha(), 
			new CardapioNoite());
	
	/**
	 * Classe responsavel por retornar o pedido conforme a entrada
	 * @param entradaPedido
	 * @return Pedido
	 */
	public Pedido retornarPedido(String entradaPedido){
		
		ConsistenciaPedido consistencia = new ConsistenciaPedido();
		Pedido pedido = null;
		if(!consistencia.validarDadosEntradaPedido(entradaPedido)){
			String [] entradas = StringUtils.split(entradaPedido, ",");
			
			String periodo = entradas[0].toLowerCase();
			List<Integer> codigos = new ArrayList<>();
			for (int i = 1; i < entradas.length; i++) {
				codigos.add(Integer.valueOf(entradas[i].trim()));
				
			}
			
			pedido = criarPedido(periodo, codigos);
		}
		
		return pedido;
	}
	
	/**
	 * Metodo responsavel por criar pedido e realizar consistencia
	 * @param periodo
	 * @param codigos
	 * @return Pedido
	 */
	private Pedido criarPedido(String periodo, List<Integer> codigos){
		List<Prato> pratosEscolhidos = new ArrayList<>();
		ConsistenciaPedido consistenciaPedido = new ConsistenciaPedido();
		boolean pedidoComErro = false;
		Optional<Cardapio> cardario = cardapios.stream()
										.filter(cdt -> cdt.periodo().equals(periodo))
										.findFirst();
		

		if(cardario.isPresent()){
			for(Integer codigoPrato : codigos){
				
				Prato prato = cardario.get().getPrato(codigoPrato);
				
				if(prato != null){
					
					pedidoComErro = adicionarPratoNoPedidoEValidar(pratosEscolhidos, consistenciaPedido, prato);
				}else{
					pedidoComErro = true;
				}				

				
				if(pedidoComErro){
					break;
				}
			}
			
			Collections.sort(pratosEscolhidos);
		}else{
			pedidoComErro = true;
		}
		
		return new Pedido(pratosEscolhidos, pedidoComErro);
	}


	/**
	 * Metodo responael por adicionar prato no pedido e realizar a consistencia das regras do prato
	 * @param pratosEscolhidos
	 * @param consistenciaPedido
	 * @param prato
	 * @return
	 */
	private boolean adicionarPratoNoPedidoEValidar(List<Prato> pratosEscolhidos, ConsistenciaPedido consistenciaPedido,
			Prato prato) {
		
		PedidoHelper pedidoHelper = new PedidoHelper();
		boolean pedidoComErro;
		if(pedidoHelper.pratoJaExisteNoPedido(prato, pratosEscolhidos)){
			pedidoHelper.adicionarQuantidade(prato, pratosEscolhidos);
		}else{
			pratosEscolhidos.add(prato);						
		}
		
		pedidoComErro = consistenciaPedido.validarRegrasPedido(prato);
		return pedidoComErro;
	}
	

	
}
