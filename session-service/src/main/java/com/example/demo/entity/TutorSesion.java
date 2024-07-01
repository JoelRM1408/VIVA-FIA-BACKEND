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
@Table(name = "TUTOR_SESION")
public class TutorSesion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TUTOR_SES")
	private int idTutorses;
	
	@ManyToOne
	@JoinColumn(name = "TUTOR_ID")
	private Tutor tutor;
	
	@ManyToOne
	@JoinColumn(name = "SESION_ID")
	private Sesion sesion;

	public TutorSesion() {
		
	}

	public TutorSesion(Tutor tutor, Sesion sesion) {
		this.tutor = tutor;
		this.sesion = sesion;
	}

	public int getIdTutorses() {
		return idTutorses;
	}

	public void setIdTutorses(int idTutorses) {
		this.idTutorses = idTutorses;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

}
