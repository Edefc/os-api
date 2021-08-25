package com.edenilson.osapi.config;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.edenilson.osapi.services.DBService;

@Configuration
@Profile(value = { "dev" })
public class DevConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;

	@Bean
	public boolean instanciaDB() {

		if (ddl.equals("create")) {
			this.dbService.instanciaDB();
		}
		return false;
	}

}
