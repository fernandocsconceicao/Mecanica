package com.ti89.mecanica.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ti89.mecanica.domain.Cliente;
import com.ti89.mecanica.domain.Visita;

	public class ClienteVisitasDTO implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		
		private Integer id;
		
	
		private List<Visita> visitas= new ArrayList<>();
		
		
	public	ClienteVisitasDTO(){
				
			}
	


	public ClienteVisitasDTO(Integer id, String nome, String cpf, String cnpj, String telefone, String celular, String email) {
		super();
		this.id = id;
		
		nome= null;
		cpf=null;
		cnpj= null;
		telefone=null;
		celular=null;
		email=null;
		
				
			}
	
	public ClienteVisitasDTO(Cliente obj) {
		id = obj.getId();
		visitas= obj.getVisitas();
		
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}



	public List<Visita> getVisitas() {
		return visitas;
	}



	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}


	
	
	

	






	
	
}
