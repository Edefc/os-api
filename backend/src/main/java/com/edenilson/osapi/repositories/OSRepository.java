package com.edenilson.osapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edenilson.osapi.entities.OS;

@Repository
public interface OSRepository extends JpaRepository<OS, Integer> {

}
