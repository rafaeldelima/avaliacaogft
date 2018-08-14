package com.gft.avaliacao.commons;

import java.util.List;

/**
 * POJO do objeto Pedido
 * @author rafab
 *
 */
public class Pedido {

	private String periodo;
	private List<Prato> pratos;
	private boolean comErro = false;
	
	public Pedido(List<Prato> pratos, boolean pedidoComErro){
		this.pratos = pratos;
		this.comErro = pedidoComErro;
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	public boolean isComErro() {
		return comErro;
	}

	public void setComErro(boolean comErro) {
		this.comErro = comErro;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}
}
