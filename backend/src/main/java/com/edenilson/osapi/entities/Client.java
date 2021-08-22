package com.edenilson.osapi.entities;

import java.io.Serializable;

public class Client extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}

	public Client(Integer id, String name, String cpf, String phone) {
		super(id, name, cpf, phone);
	}

}
