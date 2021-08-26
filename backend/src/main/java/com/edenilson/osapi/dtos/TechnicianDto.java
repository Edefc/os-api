package com.edenilson.osapi.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import com.edenilson.osapi.entities.Technician;

public class TechnicianDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;

	@CPF
	private String cpf;
	private String phone;

	public TechnicianDto() {
		super();
	}

	public TechnicianDto(Technician objTechnian) {
		super();
		this.id = objTechnian.getId();
		this.name = objTechnian.getName();
		this.cpf = objTechnian.getCpf();
		this.phone = objTechnian.getPhone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
