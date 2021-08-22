package com.edenilson.osapi.entities;

import java.io.Serializable;

public class Technician extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	public Technician() {
		super();
	}

	public Technician(Integer id, String name, String cpf, String phone) {
		super(id, name, cpf, phone);
	}

}
