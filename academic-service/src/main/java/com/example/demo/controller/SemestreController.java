package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.DTO.SemestreDTO;
import com.example.demo.entity.Semestre;
import com.example.demo.service.SemestreService;

@RestController
@RequestMapping("/apisemestre")
public class SemestreController {
	@Autowired
	SemestreService semestreService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Semestre>> listar(){
		List<Semestre> listaSemestre =semestreService.Listar();
		return new ResponseEntity<List<Semestre>>(listaSemestre, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Semestre>getById(@PathVariable("id")int id){
		if(!semestreService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Semestre semestre =semestreService.findById(id).get();
			return new ResponseEntity<Semestre>(semestre,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody SemestreDTO semestreDTO){
		Semestre semestre = new Semestre(semestreDTO.getNombresem());
		semestreService.save(semestre);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody SemestreDTO semestreDTO){
		if(!semestreService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Semestre semestre = semestreService.findById(id).get();
		semestre.setNombresem(semestreDTO.getNombresem());
		semestreService.save(semestre);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!semestreService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			semestreService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
}
