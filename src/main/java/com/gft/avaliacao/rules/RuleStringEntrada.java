package com.gft.avaliacao.rules;

import org.apache.commons.lang3.StringUtils;

import com.gft.avaliacao.constantes.ConstantesPedido;

/**
 * Classe responsavel por aplicar as regras validando os dados de entrada informado
 * @author rafab
 *
 */
public class RuleStringEntrada implements Rule<String> {

	@Override
	public boolean aplicarRegra(String entrada) {
		boolean pedidoComErro = false;
		if (StringUtils.isEmpty(entrada)) {
			pedidoComErro = true;
		} else {

			String[] entradas = StringUtils.split(entrada, ",");

			String periodo = entradas[0].toLowerCase();

			if (!ConstantesPedido.MANHA.equalsIgnoreCase(periodo)
					&& !ConstantesPedido.NOITE.equalsIgnoreCase(periodo)) {
				pedidoComErro = true;
			}
		}

		return pedidoComErro;
	}

}
