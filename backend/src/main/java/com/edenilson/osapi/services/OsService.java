package com.edenilson.osapi.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenilson.osapi.dtos.OSDto;
import com.edenilson.osapi.entities.Client;
import com.edenilson.osapi.entities.OS;
import com.edenilson.osapi.entities.Technician;
import com.edenilson.osapi.enuns.Priority;
import com.edenilson.osapi.enuns.Status;
import com.edenilson.osapi.repositories.OSRepository;
import com.edenilson.osapi.services.exceptions.ObjectNotFoundException;

@Service
public class OsService {

	@Autowired
	private OSRepository osRepository;
	
	@Autowired
	private TechnicianService technicianService;
	
	@Autowired
	private ClientService clientService;

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

	
	public OS create(@Valid OSDto objOs) {
		
		return fromDto(objOs);
	}
	public OS update(OSDto objOsDto) {
		findById(objOsDto.getId());
		return fromDto(objOsDto);
	}
	
	/*
	 * Método auxiliar para criar uma Ordem de Serviço
	 */
	private OS fromDto(OSDto objOs) {
		OS newObjOs = new OS();
		newObjOs.setId(objOs.getId());
		newObjOs.setObservance(objOs.getObservance());
		newObjOs.setPriority(Priority.toEnum(objOs.getPriority()));
		newObjOs.setStatus(Status.toEnum(objOs.getStatus()));
		
		Technician tec = technicianService.findById(objOs.getTechnician());
		newObjOs.setTechnician(tec);
		
		Client cli = clientService.findById(objOs.getClient());
		newObjOs.setClient(cli);
		
		if(newObjOs.getStatus().getCod().equals(2)) {
			newObjOs.setDateClosing(LocalDateTime.now());
		}
		
		return osRepository.save(newObjOs);
		
		
	}

}












