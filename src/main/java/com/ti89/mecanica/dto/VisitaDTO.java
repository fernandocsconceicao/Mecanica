package com.ti89.mecanica.dto;

import java.io.Serializable;
import java.util.Date;

import com.ti89.mecanica.domain.Visita;

public class VisitaDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date dataVisita;
	
	
	public VisitaDTO(){
		
	}

	
	public VisitaDTO(Visita obj) {
		this.id=obj.getId();
		this.dataVisita=obj.getDataVisita();
		
		
	}
	public VisitaDTO(Integer id, Date dataVisita) {
		super();
		this.id = id;
		this.dataVisita = dataVisita;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDataVisita() {
		return dataVisita;
	}


	public void setDataVisita(Date dataVisita) {
		this.dataVisita = dataVisita;
	}
	
	
}

	