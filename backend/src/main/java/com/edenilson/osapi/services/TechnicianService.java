package com.edenilson.osapi.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenilson.osapi.entities.Technician;
import com.edenilson.osapi.repositories.TechnicianRepository;
import com.edenilson.osapi.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicianService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private TechnicianRepository technicianRepository;

	public Technician findById(Integer id) {

		Optional<Technician> objTechnician = technicianRepository.findById(id);
		return objTechnician.orElseThrow(() -> new ObjectNotFoundException(
				"Tecnico não encontrado! " + id + ", Tipo " + Technician.class.getName()));
	}

	public List<Technician> findAll() {
		return technicianRepository.findAll();
	}

}
