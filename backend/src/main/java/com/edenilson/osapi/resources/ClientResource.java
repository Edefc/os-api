package com.edenilson.osapi.resources;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edenilson.osapi.dtos.ClientDto;
import com.edenilson.osapi.entities.Client;
import com.edenilson.osapi.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientService clientService;

	/*
	 * Pesquisa por Id
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDto> findById(@PathVariable Integer id) {
		// Client objClient = clientService.findById(id);
		ClientDto objClientDto = new ClientDto(clientService.findById(id));
		return ResponseEntity.ok().body(objClientDto);
	}

	/*
	 * Busca todos os técnicos
	 */
	@GetMapping
	public ResponseEntity<List<ClientDto>> findAll() {
		
		List<ClientDto> listClientDto = clientService.findAll()
				.stream().map(obj -> new ClientDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listClientDto);
		/*List<Client> listClient = clientService.findAll();
		List<ClientDto> listClientDto = new ArrayList<>();
		/*for (Client objClient : listClient) {
			listClientDto.add(new ClientDto(objClient));
		}
		listClient.forEach(obj -> listClientDto.add(new ClientDto(obj)));
		return ResponseEntity.ok().body(listClientDto);*/
	} 
	
	/*
	 * Cria um novo técnico
	 */
	@PostMapping
	public ResponseEntity<ClientDto> create(@Valid @RequestBody ClientDto objClientDto){
		Client newObjClient  = clientService.create(objClientDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObjClient.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/*
	 * Atualiza por Id
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDto> upDate(@PathVariable Integer id, @RequestBody ClientDto objClientDto){
		ClientDto newObjClientDto = new ClientDto(clientService.update(id, objClientDto));
		return ResponseEntity.ok().body(newObjClientDto);
	}
	
	/*
	 * Delete Tecnico
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}








