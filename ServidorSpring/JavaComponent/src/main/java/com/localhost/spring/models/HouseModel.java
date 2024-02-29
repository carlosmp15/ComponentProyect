package com.localhost.spring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="house")
public class HouseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHouse;
	
	@Column
	private String direccion;
	
	@Column
	private String cp;

	public Long getIdHouse() {
		return idHouse;
	}

	public void setIdHouse(Long idHouse) {
		this.idHouse = idHouse;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

}
