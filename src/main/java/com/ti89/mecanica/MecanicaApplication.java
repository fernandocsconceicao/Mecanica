package com.ti89.mecanica;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ti89.mecanica.domain.Cliente;
import com.ti89.mecanica.repositories.ClienteRepository;


@SpringBootApplication
public class MecanicaApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	

	public static void main(String[] args) {
		SpringApplication.run(MecanicaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
	Cliente cli1= new Cliente(null, "Fernando", "547935703497",null,"969644235", "teste", "fernando@bol.com");
	Cliente cli2= new Cliente(null, "Marcia", "87435703497",null,"318644235", "teste", "marcia@bol.com");
	
	//(Integer id, String modelo, String cor, String marca, String tipoVeiculo, String detalhes)

	
	
	
	//veiculoRepository.saveAll(Arrays.asList(v1,v2));
	clienteRepository.saveAll(Arrays.asList(cli1,cli2));
	
	
//	cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
//	cat2.getProdutos().addAll(Arrays.asList(p2));	
//	
//	
//	p1.getCategorias().addAll(Arrays.asList(cat1));
//	p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
//	p3.getCategorias().addAll(Arrays.asList(cat1));
//	
//
//	
//	categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
//	produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
}
