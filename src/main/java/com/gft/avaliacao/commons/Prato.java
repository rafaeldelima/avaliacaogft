package com.gft.avaliacao.commons;

/**
 * POJO do objeto prato
 * @author rafab
 *
 */
public class Prato implements Comparable<Prato>{
	
	private String descricao;
	private TipoPrato tipoPrato;
	private boolean permiteVariasOrdens = false;
	private Integer quantidade = 1;
	
	public Prato(String descricao, TipoPrato tipoPrato){
		this.descricao = descricao;
		this.tipoPrato = tipoPrato;		
	}
	
	public Prato(String descricao, TipoPrato tipoPrato, boolean permiteVariasOrdens){
		this.descricao = descricao;
		this.tipoPrato = tipoPrato;	
		this.permiteVariasOrdens = permiteVariasOrdens;
	}
	
	public Prato(String descricao, TipoPrato tipoPrato, boolean permiteVariasOrdens, Integer quantidade){
		this.descricao = descricao;
		this.tipoPrato = tipoPrato;	
		this.permiteVariasOrdens = permiteVariasOrdens;
		this.quantidade = quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public TipoPrato getTipoPrato() {
		return tipoPrato;
	}
	
	public void setTipoPrato(TipoPrato tipoPrato) {
		this.tipoPrato = tipoPrato;
	}

	public boolean isPermiteVariasOrdens() {
		return permiteVariasOrdens;
	}

	public void setPermiteVariasOrdens(boolean permiteVariasOrdens) {
		this.permiteVariasOrdens = permiteVariasOrdens;
	}

	public void adicionarQuantidade() {
		this.quantidade++;
	}
	

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Prato [descricao=" + descricao + ", tipoPrato=" + tipoPrato + ", permiteVariasOrdens="
				+ permiteVariasOrdens + "]";
	}

	@Override
	public int compareTo(Prato pratoComparar) {
		if(this.tipoPrato.getCodigo() < pratoComparar.getTipoPrato().getCodigo()){
			return -1;
		}
		if(this.tipoPrato.getCodigo() > pratoComparar.getTipoPrato().getCodigo()){
			return 1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (permiteVariasOrdens ? 1231 : 1237);
		result = prime * result + ((tipoPrato == null) ? 0 : tipoPrato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (permiteVariasOrdens != other.permiteVariasOrdens)
			return false;
		if (tipoPrato != other.tipoPrato)
			return false;
		return true;
	}
	
	
	
}
