package com.ti89.mecanica;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ti89.mecanica.domain.Cliente;
import com.ti89.mecanica.domain.Veiculo;
import com.ti89.mecanica.repositories.ClienteRepository;
import com.ti89.mecanica.repositories.VeiculoRepository;


@SpringBootApplication
public class MecanicaApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MecanicaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
	Cliente cli1= new Cliente(null, "Fernando", "547935703497",null,"969644235", "teste", "fernando@bol.com");
	Cliente cli2= new Cliente(null, "Marcia", "87435703497",null,"318644235", "teste", "marcia@bol.com");
	
	//(Integer id, String modelo, String cor, String marca, String tipoVeiculo, String detalhes)
	Veiculo v1 = new Veiculo(null, "Fusca", "Azul", "Volkswagen","Carro", "carro com 3 portas",cli1);
	Veiculo v2 = new Veiculo(null, "B600", "Prata", "BMW","Moto", "potente",cli2);
	Veiculo v3 = new Veiculo(null, "Celta", "Preto", "Chevrolet","Carro", "Tunado",cli2);
	Veiculo v4 = new Veiculo(null, "v20", "Prata", "Volvo","Caminhao", "Bem conservado",cli1);
	cli1.getVeiculos().addAll(Arrays.asList(v1,v4));
	cli2.getVeiculos().addAll(Arrays.asList(v2,v3));
	
	
	
	
	
	clienteRepository.saveAll(Arrays.asList(cli1,cli2));
	veiculoRepository.saveAll(Arrays.asList(v1,v2,v3,v4));
	
	
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
