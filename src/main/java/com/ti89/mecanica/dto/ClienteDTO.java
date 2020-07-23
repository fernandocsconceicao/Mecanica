package com.ti89.mecanica.dto;

import java.io.Serializable;

import com.ti89.mecanica.domain.Cliente;

	public class ClienteDTO implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		
		private Integer id;
		
		private String nome;
		private String cpf;
		private String cnpj;
		private String telefone;
		private String celular;
		private String email;
		
		
	public	ClienteDTO(){
				
			}
	


	public ClienteDTO(Integer id, String nome, String cpf, String cnpj, String telefone, String celular, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		cpf= obj.getCpf();
		cnpj= obj.getCnpj();
		telefone=obj.getTelefone();
		celular=obj.getCelular();
		email=obj.getEmail();
		
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	

	






	
	
}
