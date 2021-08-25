package com.edenilson.osapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edenilson.osapi.entities.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

}
