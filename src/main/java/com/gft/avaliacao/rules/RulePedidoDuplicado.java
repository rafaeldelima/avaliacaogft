package com.gft.avaliacao.rules;

import com.gft.avaliacao.commons.Prato;

/**
 * Classe responsavel por aplicar as regras para pedido duplicado
 * @author rafab
 *
 */
public class RulePedidoDuplicado implements Rule<Prato>{

	@Override
	public boolean aplicarRegra(Prato prato) {
		boolean regraComErro = false;
		if (prato.getQuantidade() > 1 && !prato.isPermiteVariasOrdens()) {
			regraComErro = true;
		}
		return regraComErro;
	}

}
