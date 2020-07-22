package com.ti89.mecanica.domain.enums;

public enum TipoVeiculo {
	CAMINHAO(1,"Caminhão"),
	CARRO(2,"Carro"),
	MOTO(3, "Moto");
	
	private int cod;
	private String descricao;
	
	
	
	private TipoVeiculo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoVeiculo toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for(TipoVeiculo x : TipoVeiculo.values()) {
			if(id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido: "+ id);
	}

}
