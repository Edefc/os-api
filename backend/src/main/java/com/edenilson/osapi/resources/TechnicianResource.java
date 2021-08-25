package com.edenilson.osapi.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edenilson.osapi.entities.Technician;
import com.edenilson.osapi.services.TechnicianService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TechnicianResource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TechnicianService technicianService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Technician> findById(@PathVariable Integer id) {
		Technician objTechnician = technicianService.findById(id);
		return ResponseEntity.ok().body(objTechnician);
	}

}
