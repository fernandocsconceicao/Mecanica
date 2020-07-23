package com.ti89.mecanica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ti89.mecanica.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Integer> {

}
