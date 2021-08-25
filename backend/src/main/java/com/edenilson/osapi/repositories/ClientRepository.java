package com.edenilson.osapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edenilson.osapi.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
