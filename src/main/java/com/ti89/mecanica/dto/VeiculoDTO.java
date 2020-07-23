package com.ti89.mecanica.dto;

import java.io.Serializable;

import com.ti89.mecanica.domain.Veiculo;

public class VeiculoDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String modelo;
	private String cor;
	private String marca;
	private String TipoVeiculo;
	private String detalhes;
	
	
	public VeiculoDTO(){
		
	}


	public VeiculoDTO(Integer id, String modelo, String cor, String marca, String tipoVeiculo, String detalhes) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.cor = cor;
		this.marca = marca;
		this.TipoVeiculo = tipoVeiculo;
		this.detalhes = detalhes;
	}
	
	public VeiculoDTO(Veiculo obj) {
		this.id= obj.getId();
		this.modelo=obj.getModelo();
		this.cor= obj.getCor();
		this.marca= obj.getMarca();
		this.TipoVeiculo= obj.getTipoVeiculo();
		this.detalhes= obj.getDetalhes();
		
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getTipoVeiculo() {
		return TipoVeiculo;
	}


	public void setTipoVeiculo(String tipoVeiculo) {
		TipoVeiculo = tipoVeiculo;
	}


	public String getDetalhes() {
		return detalhes;
	}


	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	
	
}
