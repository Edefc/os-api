package com.edenilson.osapi.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenilson.osapi.dtos.TechnicianDto;
import com.edenilson.osapi.entities.Person;
import com.edenilson.osapi.entities.Technician;
import com.edenilson.osapi.repositories.PersonRepository;
import com.edenilson.osapi.repositories.TechnicianRepository;
import com.edenilson.osapi.services.exceptions.DataIntegratyViolationException;
import com.edenilson.osapi.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicianService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private TechnicianRepository technicianRepository;
	
	@Autowired
	private PersonRepository personRepository;

	/*
	 * Pesquisa por Id
	 */
	public Technician findById(Integer id) {

		Optional<Technician> objTechnician = technicianRepository.findById(id);
		return objTechnician.orElseThrow(() -> new ObjectNotFoundException(
				"Tecnico não encontrado! " + id + ", Tipo " + Technician.class.getName()));
	}

	/*
	 * Busca todos os técnicos
	 */
	public List<Technician> findAll() {
		return technicianRepository.findAll();
	}

	/*
	 * Cria um novo técnico
	 */
	public Technician create(TechnicianDto objTechnicianDto) {
		/*
		 * Technician newObjTechnician = new Technician(null,
		 * objTechnicianDto.getName(), objTechnicianDto.getCpf(),
		 * objTechnicianDto.getPhone()); return
		 * technicianRepository.save(newObjTechnician);
		 */
		if (findByCpf(objTechnicianDto) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados! ");
		}
		return technicianRepository.save(new Technician(null, objTechnicianDto.getName(), objTechnicianDto.getCpf(),
				objTechnicianDto.getPhone()));

	}

	/*
	 * Atualiza por Id
	 */
	public Technician update(Integer id, TechnicianDto objTechnicianDto) {
		Technician oldObjTechnician = findById(id);

		if (findByCpf(objTechnicianDto) != null && findByCpf(objTechnicianDto).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados! ");
		} else {
			oldObjTechnician.setName(objTechnicianDto.getName());
			oldObjTechnician.setCpf(objTechnicianDto.getCpf());
			oldObjTechnician.setPhone(objTechnicianDto.getPhone());
			return technicianRepository.save(oldObjTechnician);
		}
	}

	/*
	 * Delete por Id
	 */
	public void delete(Integer id) {
		Technician objTechnician = findById(id);

		if (objTechnician.getListOs().size() > 0) {
			throw new DataIntegratyViolationException("Técnico possue ordem de serviço não pode ser deletado");

		}
		technicianRepository.deleteById(id);

	}

	/*
	 * Busca técnico pelo CPF
	 */
	public Person findByCpf(TechnicianDto objTechnicianDto) {
		Person objTechnician = personRepository.findByCpf(objTechnicianDto.getCpf());
		
		if (objTechnician != null) {
			return objTechnician;
		}
		return null;
	}

}
