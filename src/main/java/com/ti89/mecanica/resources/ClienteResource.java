package com.ti89.mecanica.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ti89.mecanica.domain.Cliente;
import com.ti89.mecanica.services.ClienteService;

@RestController
@RequestMapping(value= "/clientes")
	public class ClienteResource {
	
		@Autowired
		private ClienteService service;
		
		@RequestMapping( method= RequestMethod.GET)
		public ResponseEntity<List<Cliente>> list() {
			List<Cliente> lista = service.listar();
			
		
		return ResponseEntity.ok().body(lista);
	}
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<List<CategoriaDTO>> findAll() {
//		List<Categoria> list = service.findAll();
//		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());  
//		return ResponseEntity.ok().body(listDto);
//	}


}
