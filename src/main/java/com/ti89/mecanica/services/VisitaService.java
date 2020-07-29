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
import com.ti89.mecanica.domain.Visita;
import com.ti89.mecanica.dto.VisitaDTO;
import com.ti89.mecanica.repositories.ClienteRepository;
import com.ti89.mecanica.repositories.VisitaRepository;


@Service
public class VisitaService {
	@Autowired
	private	VisitaRepository repo;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	public List<Visita> listar(){
		return repo.findAll();
		
	}
	public Visita insert(Visita obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Visita update(Visita obj) {
		Visita newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	public Visita find(Integer id) {
		 Optional<Visita> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Visita.class.getName()));
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
	public List<Visita> findAll() {
		return repo.findAll();
	}
	
	public Page<Visita> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	///(Integer id, String modelo, String cor, String marca, String tipoVisita, String detalhes)
	public Visita fromDTO(VisitaDTO objDto) {
		return new Visita(objDto.getId(), objDto.getDataVisita()); // Apenas com id e data 
	}
	//(Integer id, Cliente cliente, Veiculo veiculo, Date dataAgendamento, boolean estadoPagamento,
	//Date dataVisita, String detalhes)
	private void updateData(Visita newObj, Visita obj) { //  atualizar o new obj antes que seja novamente manipulado
		newObj.setCliente(obj.getCliente());
		newObj.setVeiculo(obj.getVeiculo());
		newObj.setDataAgendamento(obj.getDataAgendamento());
		newObj.setEstadoPagamento(obj.isEstadoPagamento());
		newObj.setDetalhes(obj.getDetalhes());
	
	}
	
//	public Page<Visita> listByCli (Integer idCli,Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		Integer idCliente=(clienteRepository.findById(idCli).get().getId());
//		
//		
//		return (Page<Visita>) repo.findByIdcliente(idCliente);
//	}
	



}
