package com.ti89.mecanica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ti89.cursomc.services.exceptions.DataIntegrityException;
import com.ti89.cursomc.services.exceptions.ObjectNotFoundException;
import com.ti89.mecanica.domain.Cliente;
import com.ti89.mecanica.dto.ClienteDTO;
import com.ti89.mecanica.repositories.ClienteRepository;


@Service
public class ClienteService {
	@Autowired
	ClienteRepository repo;

	
	
	
	public List<Cliente> listar(){
		return repo.findAll();
		
	}
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	public Cliente find(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		} 
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Exclusão invalida");
		}
	}
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(),objDto.getCpf(),objDto.getCnpj(),objDto.getTelefone(),objDto.getCelular(),objDto.getEmail());
	}

	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
	
}
//	public Cliente fromDTO(ClienteDTO objDto) {
//		return new Cliente(objDto.getId(), objDto.getNome());
//	}

	
		
	
//	public Cliente find(Integer id) {
//		 Optional<Cliente> obj = repo.findById(id);
//		return obj.orElse(null);
//		} 
//
//	
	


}
