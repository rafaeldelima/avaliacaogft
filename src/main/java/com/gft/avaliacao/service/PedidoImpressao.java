package com.gft.avaliacao.service;

import com.gft.avaliacao.commons.Pedido;
import com.gft.avaliacao.commons.Prato;
import com.gft.avaliacao.constantes.ConstantesPedido;

/**
 * Classe responsavel por manter as regras de impressao do pedido
 * @author rafab
 *
 */
public class PedidoImpressao {

	private PedidoImpressao(){
		
	}
	
	/**
	 * Metodo responsavel por realizar a impressao do pedido
	 * @param pedido
	 * @return
	 */
	public static String imprimirPedido(Pedido pedido){
		StringBuilder stringPedido = new StringBuilder();
		
		if(pedido == null){
			return ConstantesPedido.ERROR;
		}
		
		boolean primeiroItemPedido = true;
		for(Prato prato : pedido.getPratos()){
			if(primeiroItemPedido){
				stringPedido.append(prato.getDescricao())
						.append(prato.getQuantidade() == 1 ? "" : "(x" + prato.getQuantidade() + ")");
				primeiroItemPedido = false;
			}else{
				stringPedido.append(", ").append(prato.getDescricao())
						.append(prato.getQuantidade() == 1 ? "" : "(x" + prato.getQuantidade() + ")");
				
			}
		}
		
		if(pedido.isComErro()){
			stringPedido.append(", ").append(ConstantesPedido.ERROR);
		}
		
		return stringPedido.toString();
	}
	
	
}
