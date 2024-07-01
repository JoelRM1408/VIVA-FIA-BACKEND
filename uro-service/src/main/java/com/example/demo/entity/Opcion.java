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
@Table(name = "OPCION")
public class Opcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OPCION")
	private int idOpcion;
	
	@Column(name = "MODULO")
	private String modulo;
	
	@Column(name = "RUTA_ACCESO")
	private String rutaccs;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "opcion")
	@JsonIgnore
	private List<UsuarioOpcion> usuariopcs;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "opcion")
	@JsonIgnore
	private List<RolOpcion> rolopcs;

	public Opcion() {
		
	}

	public Opcion(String modulo, String rutaccs, List<UsuarioOpcion> usuariopcs, List<RolOpcion> rolopcs) {
		this.modulo = modulo;
		this.rutaccs = rutaccs;
		this.usuariopcs = usuariopcs;
		this.rolopcs = rolopcs;
	}

	public int getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getRutaccs() {
		return rutaccs;
	}

	public void setRutaccs(String rutaccs) {
		this.rutaccs = rutaccs;
	}

	public List<UsuarioOpcion> getUsuariopcs() {
		return usuariopcs;
	}

	public void setUsuariopcs(List<UsuarioOpcion> usuariopcs) {
		this.usuariopcs = usuariopcs;
	}

	public List<RolOpcion> getRolopcs() {
		return rolopcs;
	}

	public void setRolopcs(List<RolOpcion> rolopcs) {
		this.rolopcs = rolopcs;
	}
	
}
