package com.edenilson.osapi.services;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edenilson.osapi.entities.Client;
import com.edenilson.osapi.entities.OS;
import com.edenilson.osapi.entities.Technician;
import com.edenilson.osapi.enuns.Priority;
import com.edenilson.osapi.enuns.Status;
import com.edenilson.osapi.repositories.ClientRepository;
import com.edenilson.osapi.repositories.OSRepository;
import com.edenilson.osapi.repositories.TechnicianRepository;

@Service
public class DBService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private TechnicianRepository technicianRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {

		Technician t1 = new Technician(null, "Edenilson", "775.084.640-95", "41 - 98888-8888");
		Client c1 = new Client(null, "Betina Campos", "837.358.920-19", "41 - 97777-7777");
		OS os1 = new OS(null, Priority.ALTA, "Teste create OD", Status.ANDAMENTO, t1, c1);

		t1.getListOs().add(os1);
		c1.getListOs().add(os1);

		technicianRepository.saveAll(Arrays.asList(t1));
		clientRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));

	}

}
