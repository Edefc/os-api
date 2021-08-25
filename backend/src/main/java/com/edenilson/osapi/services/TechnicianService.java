package com.edenilson.osapi.services;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenilson.osapi.entities.Technician;
import com.edenilson.osapi.repositories.TechnicianRepository;

@Service
public class TechnicianService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TechnicianRepository technicianRepository;
	
	public Technician findById(Integer id) {
		
		Optional<Technician> objTechnician = technicianRepository.findById(id);
		return objTechnician.orElse(null);
	}

}
