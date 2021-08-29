package com.edenilson.osapi.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.edenilson.osapi.entities.OS;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OSDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime openDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime closingDate;
	
	private Integer priority;
	
	@NotEmpty(message = "O campo OBSERVAÇÕES é requerido")
	private String observance;
	private Integer status;
	
	//@NotEmpty(message = "O campo TÉCNICO é requerido")
	private Integer technician;

	//@NotEmpty(message = "O campo CLIENTE é requerido")
	private Integer client;

	public OSDto() {
		super();
	}

	public OSDto(OS objOs) {
		super();
		this.id = objOs.getId();
		this.openDate = objOs.getOpenDate();
		this.closingDate = objOs.getDateClosing();
		this.priority = objOs.getPriority().getCod();
		this.observance = objOs.getObservance();
		this.status = objOs.getStatus().getCod();
		this.technician = objOs.getTechnician().getId();
		this.client = objOs.getClient().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDateTime openDate) {
		this.openDate = openDate;
	}

	public LocalDateTime getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDateTime closingDate) {
		this.closingDate = closingDate;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getObservance() {
		return observance;
	}

	public void setObservance(String observance) {
		this.observance = observance;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTechnician() {
		return technician;
	}

	public void setTechnician(Integer technician) {
		this.technician = technician;
	}

	public Integer getClient() {
		return client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}

}
