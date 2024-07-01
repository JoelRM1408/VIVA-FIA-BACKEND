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

import com.example.demo.DTO.TutorSesionDTO;
import com.example.demo.client.PersonClient;
import com.example.demo.entity.Tutor;
import com.example.demo.entity.TutorSesion;
import com.example.demo.entity.Sesion;
import com.example.demo.service.TutorSesionService;
import com.example.demo.service.SesionService;

@RestController
@RequestMapping("apiasistencia")
public class TutorSesionController {
	
	@Autowired
	TutorSesionService tutorsesService;
	
	@Autowired
	SesionService sesionService;
	
	@Autowired
	PersonClient personClient;
	
	@GetMapping("/listar")
	public ResponseEntity<List<TutorSesion>> listar(){
		List<TutorSesion> listaTutorSes=tutorsesService.Listar();
		return new ResponseEntity<List<TutorSesion>>(listaTutorSes,HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<TutorSesion>getById(@PathVariable("id") int id){
		if(!tutorsesService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			TutorSesion tutorses =tutorsesService.findById(id).get();
			return new ResponseEntity<TutorSesion>(tutorses,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody TutorSesionDTO tutorSesionDTO){
		Optional<Sesion> sesion = sesionService.findById(tutorSesionDTO.getIdSesion());
		Optional<Tutor> tutor = personClient.getTutorById(tutorSesionDTO.getIdTutor());
		
		TutorSesion tutorses = new TutorSesion(tutor.get(),sesion.get());
		tutorsesService.save(tutorses);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody TutorSesionDTO tutorSesionDTO){
		if(!sesionService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Optional<Sesion> sesion = sesionService.findById(tutorSesionDTO.getIdSesion());
		Optional<Tutor> tutor = personClient.getTutorById(tutorSesionDTO.getIdTutor());
		
		TutorSesion tutorses = tutorsesService.findById(id).get();
		tutorses.setSesion(sesion.get());
		tutorses.setTutor(tutor.get());	
		tutorsesService.save(tutorses);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!tutorsesService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			tutorsesService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}