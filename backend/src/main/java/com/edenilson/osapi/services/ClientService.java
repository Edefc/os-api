package com.edenilson.osapi.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenilson.osapi.dtos.ClientDto;
import com.edenilson.osapi.entities.Client;
import com.edenilson.osapi.entities.Person;
import com.edenilson.osapi.repositories.ClientRepository;
import com.edenilson.osapi.repositories.PersonRepository;
import com.edenilson.osapi.services.exceptions.DataIntegratyViolationException;
import com.edenilson.osapi.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientRepository technicianRepository;
	
	@Autowired
	private PersonRepository personRepository;

	/*
	 * Pesquisa por Id
	 */
	public Client findById(Integer id) {

		Optional<Client> objClient = technicianRepository.findById(id);
		return objClient.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrado! " + id + ", Tipo " + Client.class.getName()));
	}

	/*
	 * Busca todos os técnicos
	 */
	public List<Client> findAll() {
		return technicianRepository.findAll();
	}

	/*
	 * Cria um novo técnico
	 */
	public Client create(ClientDto objClientDto) {
		/*
		 * Client newObjClient = new Client(null,
		 * objClientDto.getName(), objClientDto.getCpf(),
		 * objClientDto.getPhone()); return
		 * technicianRepository.save(newObjClient);
		 */
		if (findByCpf(objClientDto) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados! ");
		}
		return technicianRepository.save(new Client(null, objClientDto.getName(), objClientDto.getCpf(),
				objClientDto.getPhone()));

	}

	/*
	 * Atualiza por Id
	 */
	public Client update(Integer id, ClientDto objClientDto) {
		Client oldObjClient = findById(id);

		if (findByCpf(objClientDto) != null && findByCpf(objClientDto).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados! ");
		} else {
			oldObjClient.setName(objClientDto.getName());
			oldObjClient.setCpf(objClientDto.getCpf());
			oldObjClient.setPhone(objClientDto.getPhone());
			return technicianRepository.save(oldObjClient);
		}
	}

	/*
	 * Delete por Id
	 */
	public void delete(Integer id) {
		Client objClient = findById(id);

		if (objClient.getListOs().size() > 0) {
			throw new DataIntegratyViolationException("Cliente possue ordem de serviço não pode ser deletado");

		}
		technicianRepository.deleteById(id);

	}

	/*
	 * Busca técnico pelo CPF
	 */
	public Person findByCpf(ClientDto objClientDto) {
		Person objClient = personRepository.findByCpf(objClientDto.getCpf());
		
		if (objClient != null) {
			return objClient;
		}
		return null;
	}

}
