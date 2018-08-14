package com.gft.avaliacao.commons;

/**
 * Enum representando os tipos de pratos possiveiss
 * @author rafab
 *
 */
public enum TipoPrato {

	ENTRADA(1),
	ACOMPANHAMENTO(2),
	BEBIDA(3),
	SOBREMESA(4);
	
	private TipoPrato(Integer codigo){
		this.codigo = codigo;
	}
	
	private Integer codigo;

	public Integer getCodigo() {
		return codigo;
	}
	
}
