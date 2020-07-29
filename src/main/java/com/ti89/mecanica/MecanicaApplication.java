package com.ti89.mecanica;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ti89.mecanica.domain.Cliente;
import com.ti89.mecanica.domain.Veiculo;
import com.ti89.mecanica.domain.Visita;
import com.ti89.mecanica.repositories.ClienteRepository;
import com.ti89.mecanica.repositories.VeiculoRepository;
import com.ti89.mecanica.repositories.VisitaRepository;


@SpringBootApplication
public class MecanicaApplication implements CommandLineRunner{
	
	

	public static void main(String[] args) {
		SpringApplication.run(MecanicaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
	
	}
}
