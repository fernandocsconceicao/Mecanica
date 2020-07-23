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
import com.ti89.mecanica.domain.Veiculo;
import com.ti89.mecanica.dto.VeiculoDTO;
import com.ti89.mecanica.repositories.VeiculoRepository;


@Service
public class VeiculoService {
	@Autowired
	VeiculoRepository repo;

	
	
	
	public List<Veiculo> listar(){
		return repo.findAll();
		
	}
	public Veiculo insert(Veiculo obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Veiculo update(Veiculo obj) {
		Veiculo newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	public Veiculo find(Integer id) {
		 Optional<Veiculo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Veiculo.class.getName()));
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
	public List<Veiculo> findAll() {
		return repo.findAll();
	}
	
	public Page<Veiculo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	///(Integer id, String modelo, String cor, String marca, String tipoVeiculo, String detalhes)
	public Veiculo fromDTO(VeiculoDTO objDto) {
		return new Veiculo(objDto.getId(), objDto.getModelo(),objDto.getCor(),objDto.getMarca(),objDto.getTipoVeiculo(),objDto.getDetalhes()); // Sem Cliente
	}
	
	private void updateData(Veiculo newObj, Veiculo obj) { //  atualizar o new obj antes que seja novamente manipulado
		newObj.setModelo(obj.getModelo());
		newObj.setCor(obj.getCor());
		newObj.setMarca(obj.getMarca());
		newObj.setTipoVeiculo(obj.getTipoVeiculo());
		newObj.setDetalhes(obj.getDetalhes());
	
}
//	public Veiculo fromDTO(VeiculoDTO objDto) {
//		return new Veiculo(objDto.getId(), objDto.getNome());
//	}

	
		
	
//	public Veiculo find(Integer id) {
//		 Optional<Veiculo> obj = repo.findById(id);
//		return obj.orElse(null);
//		} 
//
//	
	


}
