package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private int idUsuario;
	
	@Column(name = "USER")
	private String user;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "URL_IMG")
	private String urlimg;
	
	@OneToOne
	@JoinColumn(name = "PERSONA_ID")
	private Persona persona;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@JsonIgnore
	private List<UsuarioOpcion> usuariopcs;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@JsonIgnore
	private List<UsuarioRol> usuariorols;
	
	public Usuario() {
		
	}

	public Usuario(String user, String password, String urlimg, Persona persona, List<UsuarioOpcion> usuariopcs,
			List<UsuarioRol> usuariorols) {
		this.user = user;
		this.password = password;
		this.urlimg = urlimg;
		this.persona = persona;
		this.usuariopcs = usuariopcs;
		this.usuariorols = usuariorols;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlimg() {
		return urlimg;
	}

	public void setUrlimg(String urlimg) {
		this.urlimg = urlimg;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<UsuarioOpcion> getUsuariopcs() {
		return usuariopcs;
	}

	public void setUsuariopcs(List<UsuarioOpcion> usuariopcs) {
		this.usuariopcs = usuariopcs;
	}

	public List<UsuarioRol> getUsuariorols() {
		return usuariorols;
	}

	public void setUsuariorols(List<UsuarioRol> usuariorols) {
		this.usuariorols = usuariorols;
	}

}
