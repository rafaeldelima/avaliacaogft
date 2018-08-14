package com.gft.avaliacao.rules;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Classe responsavel por aplicar as regras validando os dados de entrada informado
 * @author rafab
 *
 */
public class RulePeloMenosUmItem implements Rule<String> {

	@Override
	public boolean aplicarRegra(String entrada) {
		boolean pedidoComErro = false;
		if (StringUtils.isEmpty(entrada)) {
			pedidoComErro = true;
		} else {

			String[] entradas = StringUtils.split(entrada, ",");
			
			List<Integer> codigos = new ArrayList<>();
			for (int i = 1; i < entradas.length; i++) {
				codigos.add(Integer.valueOf(entradas[i].trim()));
				
			}
			
			if(codigos.isEmpty()){
				pedidoComErro = true;
			}
		}

		return pedidoComErro;
	}

}
