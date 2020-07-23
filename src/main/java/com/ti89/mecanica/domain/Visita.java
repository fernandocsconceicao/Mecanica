package com.ti89.mecanica.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Visita implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	@JsonIgnore
	@ManyToOne 
	@JoinColumn( name= "cliente_id")
	private Cliente cliente;
	@JsonIgnore
	@ManyToOne 
	@JoinColumn( name= "veiculo_id")
	private	Veiculo veiculo;
	private Date dataAgendamento;
	private boolean estadoPagamento;
	private Date dataVisita;
	private String detalhes;
	
	public Visita() {
		
	}
	
	
	
	
	public Visita(Integer id, Cliente cliente, Veiculo veiculo, Date dataAgendamento, boolean estadoPagamento,
			Date dataVisita, String detalhes) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.dataAgendamento = dataAgendamento;
		this.estadoPagamento = estadoPagamento;
		this.dataVisita = dataVisita;
		this.detalhes = detalhes;
	}
	public Visita (Integer id, Date dataVisita) {
		this.id= id;
		this.dataVisita= dataVisita;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public boolean isEstadoPagamento() {
		return estadoPagamento;
	}
	public void setEstadoPagamento(boolean estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}

	public Date getDataVisita() {
		return dataVisita;
	}
	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
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
		Visita other = (Visita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
