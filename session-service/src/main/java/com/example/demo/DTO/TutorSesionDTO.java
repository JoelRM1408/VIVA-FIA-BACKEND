package com.example.demo.DTO;

public class TutorSesionDTO {
	
	private int idTutor;
	private int idSesion;
	
	
	public TutorSesionDTO() {
		
	}

	public TutorSesionDTO(int idTutor, int idSesion) {
		this.idTutor = idTutor;
		this.idSesion = idSesion;
	}

	public int getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public int getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}
	
}
