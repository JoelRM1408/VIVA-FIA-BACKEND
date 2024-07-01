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
@Table(name = "TUTOR")
public class Tutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TUTOR")
	private  int idTutor;
	
	@Column(name = "CODIGO")
	private int codigotut;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
	@JsonIgnore
	private List<TutorSesion> tutorsesiones;

	public Tutor() {
		
	}

	public Tutor(int codigotut, List<TutorSesion> tutorsesiones) {
		this.codigotut = codigotut;
		this.tutorsesiones = tutorsesiones;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public int getCodigotut() {
		return codigotut;
	}

	public void setCodigotut(int codigotut) {
		this.codigotut = codigotut;
	}

	public List<TutorSesion> getTutorsesiones() {
		return tutorsesiones;
	}

	public void setTutorsesiones(List<TutorSesion> tutorsesiones) {
		this.tutorsesiones = tutorsesiones;
	}
	
}
