package com.ti89.mecanica.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Veiculo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String modelo;
	private String cor;
	private String marca;
	private String tipoVeiculo;
	@JsonIgnore
	@ManyToOne 
	@JoinColumn( name= "cliente_id")
	private Cliente cliente;
	private String detalhes;
	
	
	public Veiculo() {	
		
	}


	public Veiculo(Integer id, String modelo, String cor, String marca, String tipoVeiculo, String detalhes,Cliente cliente) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.cor = cor;
		this.marca = marca;
		this.tipoVeiculo = tipoVeiculo;
		this.detalhes = detalhes;
		this.setCliente(cliente);
	}

	public Veiculo(Integer id, String modelo, String cor, String marca, String tipoVeiculo, String detalhes) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.cor = cor;
		this.marca = marca;
		this.tipoVeiculo = tipoVeiculo;
		this.detalhes = detalhes;
		
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
		return tipoVeiculo;
	}


	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}


	public String getDetalhes() {
		return detalhes;
	}


	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	

}
