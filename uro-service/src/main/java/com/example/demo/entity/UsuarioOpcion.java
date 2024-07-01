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
@Table(name = "USUARIO_OPCION")
public class UsuarioOpcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO_OPC")
	private int idUsuariOpc;
	
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "OPCION_ID")
	private Opcion opcion;

	public UsuarioOpcion() {
		
	}

	public UsuarioOpcion(Usuario usuario, Opcion opcion) {
		this.usuario = usuario;
		this.opcion = opcion;
	}

	public int getIdUsuariOpc() {
		return idUsuariOpc;
	}

	public void setIdUsuariOpc(int idUsuariOpc) {
		this.idUsuariOpc = idUsuariOpc;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

}
