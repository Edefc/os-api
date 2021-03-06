package com.edenilson.osapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edenilson.osapi.entities.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

	/*
	 * Pesquisa CPF no banco de dados
	 */
	@Query("SELECT obj FROM Technician obj WHERE obj.cpf =:cpf")
	Technician findByCpf(@Param("cpf") String cpf);

}
