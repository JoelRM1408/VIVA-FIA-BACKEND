package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROL")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROL")
	private int idRol;
	
	@Column(name = "ROL")
	private String rol;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
	@JsonIgnore
	private List<UsuarioRol> usuariorols;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
	@JsonIgnore
	private List<RolOpcion> rolopcs;
	
	public Rol() {
		
	}

	public Rol(String rol, List<UsuarioRol> usuariorols, List<RolOpcion> rolopcs) {
		this.rol = rol;
		this.usuariorols = usuariorols;
		this.rolopcs = rolopcs;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<UsuarioRol> getUsuariorols() {
		return usuariorols;
	}

	public void setUsuariorols(List<UsuarioRol> usuariorols) {
		this.usuariorols = usuariorols;
	}

	public List<RolOpcion> getRolopcs() {
		return rolopcs;
	}

	public void setRolopcs(List<RolOpcion> rolopcs) {
		this.rolopcs = rolopcs;
	}
	
}
