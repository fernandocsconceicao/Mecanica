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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value= "/visitas")
@Api(value="Api REST Veiculo")

	public class VisitaResource {
	
		@Autowired
		private VisitaService service;
		

		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		@ApiOperation( value="retorna a visita identificado pelo id fornecido")

		public ResponseEntity<Visita> find(@PathVariable Integer id) {
			Visita obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		}
		
			
		
			
			@RequestMapping(method=RequestMethod.POST)
			@ApiOperation( value="Insere uma visita  com os dados fornecidos em um body Json ")
			public ResponseEntity<Void> insert(@Valid @RequestBody VisitaDTO objDto) {
				Visita obj = service.fromDTO(objDto);
				obj = service.insert(obj);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
				return ResponseEntity.created(uri).build();
			}
			
			@RequestMapping(value="/{id}", method=RequestMethod.PUT)
			@ApiOperation( value="Atualiza uma visita identificado pelo id no banco de dados com os dados fornecidos em um body Json")

			public ResponseEntity<Void> update(@Valid @RequestBody VisitaDTO objDto, @PathVariable Integer id) {
				Visita obj = service.fromDTO(objDto);
				obj.setId(id);
				obj = service.update(obj);
				return ResponseEntity.noContent().build();
			}
			
			@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
			@ApiOperation( value="Deleta uma visita identificado pelo id")

			public ResponseEntity<Void> delete(@PathVariable Integer id) {
				service.delete(id);
				return ResponseEntity.noContent().build();
			}
			
			@RequestMapping(method=RequestMethod.GET)
			@ApiOperation( value="Lista todos as visitas existentes")

			public ResponseEntity<List<VisitaDTO>> findAll() {
				List<Visita> list = service.findAll();
				List<VisitaDTO> listDto = list.stream().map(obj -> new VisitaDTO(obj)).collect(Collectors.toList());  
				return ResponseEntity.ok().body(listDto);
			}
			
			@RequestMapping(value="/page", method=RequestMethod.GET)
			@ApiOperation( value="Retorna todos as visitas de forma paginada,"
					+ " configurado com os atributos int page,"
					+ " int linesPerPage,"
					+ " String orderBy,"
					+ " String direction")
			public ResponseEntity<Page<VisitaDTO>> findPage(
					@RequestParam(value="page", defaultValue="0") Integer page, 
					@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
					@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
					@RequestParam(value="direction", defaultValue="ASC") String direction) {
				Page<Visita> list = service.findPage(page, linesPerPage, orderBy, direction);
				Page<VisitaDTO> listDto = list.map(obj -> new VisitaDTO(obj));  
				return ResponseEntity.ok().body(listDto);
			}
			
//		
		
		



}
