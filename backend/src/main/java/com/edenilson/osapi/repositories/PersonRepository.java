package com.edenilson.osapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edenilson.osapi.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
	/*
	 * Pesquisa CPF no banco de dados
	 */
	@Query("SELECT obj FROM Person obj WHERE obj.cpf =:cpf")
	Person findByCpf(@Param("cpf") String cpf);

}
