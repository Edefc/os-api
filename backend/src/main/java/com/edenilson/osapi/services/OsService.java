package com.edenilson.osapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenilson.osapi.entities.OS;
import com.edenilson.osapi.repositories.OSRepository;
import com.edenilson.osapi.services.exceptions.ObjectNotFoundException;

@Service
public class OsService {

	@Autowired
	private OSRepository osRepository;

	/*
	 * Pesquisa OS por Id
	 */
	public OS findById(Integer id) {
		Optional<OS> objOs = osRepository.findById(id);
		return objOs.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Tipo: " + OS.class.getName()));

	}
	/*
	 * Lista toda as OS´s
	 */
	
	public List<OS> findAll() {
		return osRepository.findAll();
	}
}
