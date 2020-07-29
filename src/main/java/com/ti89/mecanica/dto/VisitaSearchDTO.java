package com.ti89.mecanica.dto;

import java.io.Serializable;
import java.util.Date;

import com.ti89.mecanica.domain.Visita;

public class VisitaSearchDTO implements Serializable{
	

	
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Integer id;
		private Integer Cliente;
		private Date dataVisita;
		
		
		public VisitaSearchDTO(){
			
		}


		public VisitaSearchDTO(Integer id, Integer cliente, Date dataVisita) {
			super();
			this.id = id;
			Cliente = cliente;
			this.dataVisita = dataVisita;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public Integer getCliente() {
			return Cliente;
		}


		public void setCliente(Integer cliente) {
			Cliente = cliente;
		}


		public Date getDataVisita() {
			return dataVisita;
		}


		public void setDataVisita(Date dataVisita) {
			this.dataVisita = dataVisita;
		}

		
//		public VisitaSearchDTO(Visita obj) {
//			this.id=obj.getId();
//			this.dataVisita=obj.getDataVisita();
//			this.cliente=
//			
//		}
		

}
