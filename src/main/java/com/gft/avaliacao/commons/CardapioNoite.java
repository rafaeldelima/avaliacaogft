package com.gft.avaliacao.commons;

import java.util.Arrays;
import java.util.List;

import com.gft.avaliacao.constantes.ConstantesPedido;

/**
 * Classe representando o cardapio do periodo da noite
 * @author rafab
 *
 */
public class CardapioNoite implements Cardapio {

	List<Prato> opcoesDePratos = Arrays.asList(
			new Prato("bife", TipoPrato.ENTRADA),
			new Prato("batata", TipoPrato.ACOMPANHAMENTO, true),
			new Prato("vinho", TipoPrato.BEBIDA),
			new Prato("bolo", TipoPrato.SOBREMESA)
			);
	
	@Override
	public List<Prato> opcoesDePrato() {
		return opcoesDePratos;
	}

	@Override
	public String periodo() {
		return ConstantesPedido.NOITE;
	}


}
