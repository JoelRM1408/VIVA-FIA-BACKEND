package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSONA")
	private int idPersona;
	
	@Column(name = "NOMBRES")
	private String nombre;
	
	@Column(name = "APELLIDO_PAT")
	private String apepat;
	
	@Column(name = "APELLIDO_MAT")
	private String apemat;
	
	@Column(name = "DNI")
	private int dni;
	
	@Column(name = "TELEFONO")
	private int tel;
	
	@Column(name = "DIRECCION")
	private String direc;
	
	@Column(name = "CORREO_PERS")
	private String correo;
	
	@Column(name = "FECHA_NAC")
	private String fechanac;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
	@JsonIgnore
	private Usuario usuario;
	
	public Persona() {
		
	}

	public Persona(String nombre, String apepat, String apemat, int dni, int tel, String direc, String correo,
			String fechanac, Usuario usuario) {
		this.nombre = nombre;
		this.apepat = apepat;
		this.apemat = apemat;
		this.dni = dni;
		this.tel = tel;
		this.direc = direc;
		this.correo = correo;
		this.fechanac = fechanac;
		this.usuario = usuario;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApepat() {
		return apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}

	public String getApemat() {
		return apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getDirec() {
		return direc;
	}

	public void setDirec(String direc) {
		this.direc = direc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechanac() {
		return fechanac;
	}

	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
