package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.AsistenciaDTO;
import com.example.demo.client.PersonClient;
import com.example.demo.entity.Alumno;
import com.example.demo.entity.Asistencia;
import com.example.demo.entity.Sesion;
import com.example.demo.service.AsistenciaService;
import com.example.demo.service.SesionService;

@RestController
@RequestMapping("apiasistencia")
public class AsistenciaController {
	@Autowired
	AsistenciaService asistenciaService;
	
	@Autowired
	SesionService sesionService;
	
	@Autowired
	PersonClient personClient;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Asistencia>> listar(){
		List<Asistencia> listaAsistencia=asistenciaService.Listar();
		return new ResponseEntity<List<Asistencia>>(listaAsistencia,HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Asistencia>getById(@PathVariable("id") int id){
		if(!asistenciaService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Asistencia asist =asistenciaService.findById(id).get();
			return new ResponseEntity<Asistencia>(asist,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody AsistenciaDTO asistenciaDTO){
		Optional<Sesion> sesion = sesionService.findById(asistenciaDTO.getIdSesion());
		Optional<Alumno> alumno = personClient.getAlumnoById(asistenciaDTO.getIdAlumno());
		
		Asistencia asist = new Asistencia(asistenciaDTO.getEstadoasis(),sesion.get(),alumno.get());
		asistenciaService.save(asist);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody AsistenciaDTO asistenciaDTO){
		if(!sesionService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Sesion> sesion = sesionService.findById(asistenciaDTO.getIdSesion());
		Optional<Alumno> alumno = personClient.getAlumnoById(asistenciaDTO.getIdAlumno());
		
		Asistencia asist = asistenciaService.findById(id).get();
		asist.setEstadoasis(asistenciaDTO.getEstadoasis());
		asist.setSesion(sesion.get());
		asist.setAlumno(alumno.get());	
		asistenciaService.save(asist);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!asistenciaService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			asistenciaService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
