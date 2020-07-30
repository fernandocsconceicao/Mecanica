package com.ti89.mecanica.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ti89.mecanica.domain.Veiculo;
import com.ti89.mecanica.dto.VeiculoDTO;
import com.ti89.mecanica.services.VeiculoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value= "/veiculos")
@Api(value="Api REST Veiculo")
@CrossOrigin( origins="*")
	public class VeiculoResource {
	
		@Autowired
		private VeiculoService service;
		

		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		@ApiOperation( value="retorna o veiculo identificado pelo id fornecido")

		public ResponseEntity<Veiculo> find(@PathVariable Integer id) {
			Veiculo obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		}
		
			
		
			
			@RequestMapping(method=RequestMethod.POST)
			@ApiOperation( value="Insere um veiculo no banco de dados com os dados fornecidos em um body Json ")

			public ResponseEntity<Void> insert(@Valid @RequestBody VeiculoDTO objDto) {
				Veiculo obj = service.fromDTO(objDto);
				obj = service.insert(obj);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
				return ResponseEntity.created(uri).build();
			}
			
			@RequestMapping(value="/{id}", method=RequestMethod.PUT)
			@ApiOperation( value="Atualiza um veiculo identificado pelo id com os dados fornecidos em um body Json")

			public ResponseEntity<Void> update(@Valid @RequestBody VeiculoDTO objDto, @PathVariable Integer id) {
				Veiculo obj = service.fromDTO(objDto);
				obj.setId(id);
				obj = service.update(obj);
				return ResponseEntity.noContent().build();
			}
			
			@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
			@ApiOperation( value="Deleta um veiculo identificado pelo id")

			public ResponseEntity<Void> delete(@PathVariable Integer id) {
				service.delete(id);
				return ResponseEntity.noContent().build();
			}
			
			@RequestMapping(method=RequestMethod.GET)
			@ApiOperation( value="Lista todos os veiculos  existentes")

			public ResponseEntity<List<VeiculoDTO>> findAll() {
				List<Veiculo> list = service.findAll();
				List<VeiculoDTO> listDto = list.stream().map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList());  
				return ResponseEntity.ok().body(listDto);
			}
			
			@RequestMapping(value="/page", method=RequestMethod.GET)
			@ApiOperation( value="Retorna todos os veiculos de forma paginada,"
					+ " configurado com os atributos int page,"
					+ " int linesPerPage,"
					+ " String orderBy,"
					+ " String direction")

			public ResponseEntity<Page<VeiculoDTO>> findPage(
					@RequestParam(value="page", defaultValue="0") Integer page, 
					@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
					@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
					@RequestParam(value="direction", defaultValue="ASC") String direction) {
				Page<Veiculo> list = service.findPage(page, linesPerPage, orderBy, direction);
				Page<VeiculoDTO> listDto = list.map(obj -> new VeiculoDTO(obj));  
				return ResponseEntity.ok().body(listDto);
			}
		



}
