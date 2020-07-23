package com.ti89.mecanica.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ti89.mecanica.domain.Visita;
import com.ti89.mecanica.dto.VisitaDTO;
import com.ti89.mecanica.services.VisitaService;

@RestController
@RequestMapping(value= "/visitas")
	public class VisitaResource {
	
		@Autowired
		private VisitaService service;
		

		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<Visita> find(@PathVariable Integer id) {
			Visita obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		}
		
			
		
			
			@RequestMapping(method=RequestMethod.POST)
			public ResponseEntity<Void> insert(@Valid @RequestBody VisitaDTO objDto) {
				Visita obj = service.fromDTO(objDto);
				obj = service.insert(obj);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
				return ResponseEntity.created(uri).build();
			}
			
			@RequestMapping(value="/{id}", method=RequestMethod.PUT)
			public ResponseEntity<Void> update(@Valid @RequestBody VisitaDTO objDto, @PathVariable Integer id) {
				Visita obj = service.fromDTO(objDto);
				obj.setId(id);
				obj = service.update(obj);
				return ResponseEntity.noContent().build();
			}
			
			@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
			public ResponseEntity<Void> delete(@PathVariable Integer id) {
				service.delete(id);
				return ResponseEntity.noContent().build();
			}
			
			@RequestMapping(method=RequestMethod.GET)
			public ResponseEntity<List<VisitaDTO>> findAll() {
				List<Visita> list = service.findAll();
				List<VisitaDTO> listDto = list.stream().map(obj -> new VisitaDTO(obj)).collect(Collectors.toList());  
				return ResponseEntity.ok().body(listDto);
			}
			
			@RequestMapping(value="/page", method=RequestMethod.GET)
			public ResponseEntity<Page<VisitaDTO>> findPage(
					@RequestParam(value="page", defaultValue="0") Integer page, 
					@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
					@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
					@RequestParam(value="direction", defaultValue="ASC") String direction) {
				Page<Visita> list = service.findPage(page, linesPerPage, orderBy, direction);
				Page<VisitaDTO> listDto = list.map(obj -> new VisitaDTO(obj));  
				return ResponseEntity.ok().body(listDto);
			}
		



}
