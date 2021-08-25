package com.edenilson.osapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "client")
	private List<OS> listOs = new ArrayList<>();

	public Client() {
		super();
	}

	public Client(Integer id, String name, String cpf, String phone) {
		super(id, name, cpf, phone);
	}

	public List<OS> getListOs() {
		return listOs;
	}

	public void setListOs(List<OS> listOs) {
		this.listOs = listOs;
	}

}
