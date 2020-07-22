package com.ti89.mecanica.dto;

import java.io.Serializable;

	public class ClienteDTO implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		
		private Integer id;
		
		
		private String nome;
		
	public	ClienteDTO(){
				
			}
	

	


	public ClienteDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
