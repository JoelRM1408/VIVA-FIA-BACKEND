package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROL_OPCION")
public class RolOpcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL_OPC")
	private int idRolOpc;
	
	@ManyToOne
	@JoinColumn(name = "ROL_ID")
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "OPCION_ID")
	private Opcion opcion;
	
	public RolOpcion() {
		
	}

	public RolOpcion(Rol rol, Opcion opcion) {
		this.rol = rol;
		this.opcion = opcion;
	}

	public int getIdRolOpc() {
		return idRolOpc;
	}

	public void setIdRolOpc(int idRolOpc) {
		this.idRolOpc = idRolOpc;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}
	
}
