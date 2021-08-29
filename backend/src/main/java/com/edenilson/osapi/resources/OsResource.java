package com.edenilson.osapi.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edenilson.osapi.dtos.OSDto;
import com.edenilson.osapi.services.OsService;

@RestController
@RequestMapping(value = "/os")
public class OsResource {
	
	@Autowired
	private OsService  osService;
	
	
	/*
	 * Pesquisa OS por Id
	 */
	@GetMapping(value = "/{id}")	
	public ResponseEntity<OSDto> finfById(@PathVariable Integer id) {
		OSDto objOs = new OSDto(osService.findById(id));
		return ResponseEntity.ok().body(objOs);
	}
	
	/*
	 * Lista todas as OS´s
	 */
	@GetMapping
	public ResponseEntity<List<OSDto>> findAll() {
		List<OSDto> listOsDto = osService.findAll().stream().map(objOsDto -> new OSDto(objOsDto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listOsDto);
	}
	
	

}
