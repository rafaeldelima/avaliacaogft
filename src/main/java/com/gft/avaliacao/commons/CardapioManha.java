package com.gft.avaliacao.commons;

import java.util.Arrays;
import java.util.List;

import com.gft.avaliacao.constantes.ConstantesPedido;

/**
 * Classe representando o cardapio do periodo da manha
 * @author rafab
 *
 */
public class CardapioManha implements Cardapio {

	List<Prato> opcoesDePratos = Arrays.asList(
			new Prato("ovos", TipoPrato.ENTRADA),
			new Prato("torrada", TipoPrato.ACOMPANHAMENTO),
			new Prato("cafe", TipoPrato.BEBIDA, true)
			);
	
	@Override
	public List<Prato> opcoesDePrato() {
		return opcoesDePratos;
	}

	@Override
	public String periodo() {
		return ConstantesPedido.MANHA;
	}


}
