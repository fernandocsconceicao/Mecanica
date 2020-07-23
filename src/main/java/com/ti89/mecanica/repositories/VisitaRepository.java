package com.ti89.mecanica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ti89.mecanica.domain.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita,Integer> {

}
