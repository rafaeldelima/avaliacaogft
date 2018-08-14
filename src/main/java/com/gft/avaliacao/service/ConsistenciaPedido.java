package com.gft.avaliacao.service;

import java.util.Arrays;
import java.util.List;

import com.gft.avaliacao.commons.Prato;
import com.gft.avaliacao.rules.Rule;
import com.gft.avaliacao.rules.RulePedidoDuplicado;
import com.gft.avaliacao.rules.RulePeloMenosUmItem;
import com.gft.avaliacao.rules.RuleStringEntrada;

/**
 * CLasse responsavel por centralizar as regras de consistencia do Pedido
 * @author rafab
 *
 */
public class ConsistenciaPedido {

	private static final List<Rule<String>> RULES_ENTRADA_PEDIDO = Arrays.asList(
			new RuleStringEntrada(),
			new RulePeloMenosUmItem()
			);
	private static final List<Rule<Prato>> RULES_PRATO = Arrays.asList(
			new RulePedidoDuplicado());
	
	/**
	 * Aplica as regras para a criacao do pedido
	 * @param entrada
	 * @return
	 */
	public boolean validarDadosEntradaPedido(String entrada){
		for(Rule<String> rule : RULES_ENTRADA_PEDIDO){
			if(rule.aplicarRegra(entrada)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Aplica as regras para o prato informado
	 * @param prato
	 * @return
	 */
	public boolean validarRegrasPedido(Prato prato){

		for(Rule<Prato> rules : RULES_PRATO){
			if(rules.aplicarRegra(prato)){
				return true;
			}
		}
		return false;
	}
	
}
