package com.ti89.mecanica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ti89.mecanica.domain.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita,Integer> {
//	
//	List<Visita>findByIdcliente(@Param("idCli")Integer idCli);
//	List<Cliente>findByIdcliente(@Param("idCli")Integer idCli);
//	
//	@Query("SELECT DISTINCT obj FROM Visita obj WHERE obj.cliente_id == %:idCli")
//	Page<Visita> search (@Param("idCli")Integer idCli, Pageable pageRequest);

}
