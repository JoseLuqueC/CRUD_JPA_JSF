package com.soluva.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcliente;
	@Column
	private String cli_name;
	@Column
	private String cli_email;
	@Column
	private String cli_phone;
	@Column
	private String cli_address;
	@Column
	private String cli_status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getCli_name() {
		return cli_name;
	}

	public void setCli_name(String cli_name) {
		this.cli_name = cli_name;
	}

	public String getCli_email() {
		return cli_email;
	}

	public void setCli_email(String cli_email) {
		this.cli_email = cli_email;
	}

	public String getCli_phone() {
		return cli_phone;
	}

	public void setCli_phone(String cli_phone) {
		this.cli_phone = cli_phone;
	}

	public String getCli_address() {
		return cli_address;
	}

	public void setCli_address(String cli_address) {
		this.cli_address = cli_address;
	}

	public String getCli_status() {
		return cli_status;
	}

	public void setCli_status(String cli_status) {
		this.cli_status = cli_status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", cli_name=" + cli_name + ", cli_email=" + cli_email
				+ ", cli_phone=" + cli_phone + ", cli_address=" + cli_address + ", cli_status=" + cli_status + "]";
	}
	
	
}
