package com.edenilson.osapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_technician")
public class Technician extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "technician")
	private List<OS> listOs = new ArrayList<>();

	public Technician() {
		super();
	}

	public Technician(Integer id, String name, String cpf, String phone) {
		super(id, name, cpf, phone);
	}

	public List<OS> getListOs() {
		return listOs;
	}

	public void setListOs(List<OS> listOs) {
		this.listOs = listOs;
	}
}
