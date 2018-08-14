package com.gft.avaliacao.rules;

/**
 * Interface para implementacao das regras
 * @author rafab
 *
 * @param <T>
 */
public interface Rule<T> {

	public boolean aplicarRegra(T objeto);
	
}
