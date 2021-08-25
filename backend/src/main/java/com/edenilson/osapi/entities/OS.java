package com.edenilson.osapi.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edenilson.osapi.enuns.Priority;
import com.edenilson.osapi.enuns.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_os")
public class OS implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime openDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime closingDate;
	private Integer priority;
	private String observance;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "technician_id")
	private Technician technician;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public OS() {
		super();
		this.setOpenDate(LocalDateTime.now());
		this.setPriority(Priority.BAIXA);
		this.setStatus(Status.ANDAMENTO);;

	}

	public OS(Integer id, Priority priority, String observance,
			Status status, Technician technician, Client client) {
		super();
		this.id = id;
		this.openDate = LocalDateTime.now();
		this.priority = (priority == null) ? 0 : priority.getCod();
		this.observance = observance;
		this.status = (status == null) ? 0 : status.getCod();
		this.technician = technician;
		this.client = client;
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

	public LocalDateTime getOpenClosing() {
		return closingDate;
	}

	public void setOpenClosing(LocalDateTime openClosing) {
		this.closingDate = openClosing;
	}

	public Priority getPriority() {
		return Priority.toEnum(this.priority);
	}

	public void setPriority(Priority priority) {
		this.priority = priority.getCod();
	}

	public String getObservance() {
		return observance;
	}

	public void setObservance(String observance) {
		this.observance = observance;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
