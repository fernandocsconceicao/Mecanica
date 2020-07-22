package com.ti89.mecanica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ti89.mecanica.domain.Cliente;
import com.ti89.mecanica.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository repo;
	
	
	
	
	public List<Cliente> listar(){
		return repo.findAll();
		
	}
	
	


}
