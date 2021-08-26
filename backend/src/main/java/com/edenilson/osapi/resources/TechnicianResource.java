package com.edenilson.osapi.resources;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edenilson.osapi.dtos.TechnicianDto;
import com.edenilson.osapi.entities.Technician;
import com.edenilson.osapi.services.TechnicianService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TechnicianResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private TechnicianService technicianService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TechnicianDto> findById(@PathVariable Integer id) {
		// Technician objTechnician = technicianService.findById(id);
		TechnicianDto objTechnicianDto = new TechnicianDto(technicianService.findById(id));
		return ResponseEntity.ok().body(objTechnicianDto);
	}

	@GetMapping
	public ResponseEntity<List<TechnicianDto>> findAll() {
		
		List<TechnicianDto> listTechnicianDto = technicianService.findAll()
				.stream().map(obj -> new TechnicianDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listTechnicianDto);
		/*List<Technician> listTechnician = technicianService.findAll();
		List<TechnicianDto> listTechnicianDto = new ArrayList<>();
		/*for (Technician objTechnician : listTechnician) {
			listTechnicianDto.add(new TechnicianDto(objTechnician));
		}
		listTechnician.forEach(obj -> listTechnicianDto.add(new TechnicianDto(obj)));
		return ResponseEntity.ok().body(listTechnicianDto);*/
	} 
	@PostMapping
	public ResponseEntity<TechnicianDto> create(@Valid @RequestBody TechnicianDto objTechnicianDto){
		Technician newObjTechnician  = technicianService.create(objTechnicianDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObjTechnician.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
