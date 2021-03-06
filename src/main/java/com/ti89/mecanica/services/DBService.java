package com.ti89.mecanica.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ti89.mecanica.domain.Cliente;
import com.ti89.mecanica.domain.Veiculo;
import com.ti89.mecanica.domain.Visita;
import com.ti89.mecanica.repositories.ClienteRepository;
import com.ti89.mecanica.repositories.VeiculoRepository;
import com.ti89.mecanica.repositories.VisitaRepository;

@Service
public class DBService {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private VisitaRepository visitaRepository;
	public void instantiateTestDatabase() throws ParseException{
		
		Cliente cli1= new Cliente(null, "Fernando", "547935703497",null,"969644235", "teste", "fernando@bol.com");
		Cliente cli2= new Cliente(null, "Marcia", "87435703497",null,"318644235", "teste", "marcia@bol.com");
		
		
		Veiculo v1 = new Veiculo(null, "Fusca", "Azul", "Volkswagen","Carro", "carro com 3 portas",cli1);
		Veiculo v2 = new Veiculo(null, "B600", "Prata", "BMW","Moto", "potente",cli2);
		Veiculo v3 = new Veiculo(null, "Celta", "Preto", "Chevrolet","Carro", "Tunado",cli2);
		Veiculo v4 = new Veiculo(null, "v20", "Prata", "Volvo","Caminhao", "Bem conservado",cli1);

		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Visita vst1= new Visita(null, cli2, v2, sdf.parse("26/04/2015 12:00"), true,sdf.parse("01/05/2015 15:00") , "Trocada a parafuseta");
		Visita vst2= new Visita(null, cli1, v4, sdf.parse("26/04/2020 12:00"), false,sdf.parse("01/05/2021 15:00") , "");
		Visita vst3= new Visita(null, cli2, v2, sdf.parse("26/04/2019 12:00"), true,sdf.parse("15/09/2019 15:00") , "Trocada a bomba de combustivel");
		Visita vst4= new Visita(null, cli1, v1, sdf.parse("12/02/2020 12:00"), true,sdf.parse("05/10/2020 15:00") , "Trocada a parafuseta");
		
		
		
		cli1.getVeiculos().addAll(Arrays.asList(v1,v4));
		cli2.getVeiculos().addAll(Arrays.asList(v2,v3));
		
		v1.getVisitas().addAll(Arrays.asList(vst4));
		v2.getVisitas().addAll(Arrays.asList(vst1,vst3));
		//v3 Nao recebeu visitas
		v4.getVisitas().addAll(Arrays.asList(vst2));	
		
		
		
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		veiculoRepository.saveAll(Arrays.asList(v1,v2,v3,v4));
		visitaRepository.saveAll(Arrays.asList(vst1,vst2,vst3,vst4));
		
		

	}

}
