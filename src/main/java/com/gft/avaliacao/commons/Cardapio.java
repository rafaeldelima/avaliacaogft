package com.gft.avaliacao.commons;

import java.util.List;

/**
 * Interface para criacao de cardapios
 * @author rafab
 *
 */
public interface Cardapio {

	public abstract String periodo();
	public abstract List<Prato> opcoesDePrato();
	
	/**
	 * Metodo que retorna o primeito prato encontrado de acordo com o codigo do tipo de prato
	 * @param codigoPrato
	 * @return Prato encontrado ou null
	 */
	public default Prato getPrato(Integer codigoPrato){	
		Prato pratoSelecionado = null;
		for(Prato prato : opcoesDePrato()){
			if(prato.getTipoPrato().getCodigo().equals(codigoPrato)){
				pratoSelecionado = prato;
				break;
			}
		}
		
		return pratoSelecionado;
	}
}
