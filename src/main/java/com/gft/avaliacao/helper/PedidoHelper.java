package com.gft.avaliacao.helper;

import java.util.List;
import java.util.Optional;

import com.gft.avaliacao.commons.Prato;

/**
 * Classe responsavel por manter metodos utilitarios para o objeto Pedido
 * @author rafab
 *
 */
public class PedidoHelper {
	
	/**
	 * Metodo utilitario para verificar se o prato ja existe no pedido
	 * @param prato
	 * @param pratosPedido
	 * @return
	 */
	public boolean pratoJaExisteNoPedido(Prato prato, List<Prato> pratosPedido){
		return pratosPedido.stream().filter(prt -> prt.getDescricao().equals(prato.getDescricao())).findFirst().isPresent();
	}

	/**
	 * Metodo utilitario para adicionar quantidade do prato solicitado
	 * @param prato
	 * @param pratosPedido
	 */
	public void adicionarQuantidade(Prato prato, List<Prato> pratosPedido){
		Optional<Prato> pratoLista = pratosPedido.stream().filter(prt -> prt.getDescricao().equals(prato.getDescricao())).findFirst();
		if(pratoLista.isPresent()){
			pratoLista.get().adicionarQuantidade();
		}
	}
}