package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ProyectoDTO;
import com.example.demo.client.AcademicClient;
import com.example.demo.entity.Escuela;
import com.example.demo.entity.Proyecto;
import com.example.demo.entity.Semestre;
import com.example.demo.entity.TipoPro;
import com.example.demo.service.ProyectoService;
import com.example.demo.service.TipoProService;


@RestController
@RequestMapping("/apiproyecto")
public class ProyectoController {
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	TipoProService tipoproService;
	
	@Autowired
	AcademicClient academicClient;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Proyecto>> listar(){
		List<Proyecto> listaProyecto =proyectoService.Listar();
		return new ResponseEntity<List<Proyecto>>(listaProyecto, HttpStatus.OK);
	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Proyecto>getById(@PathVariable("id")int id){
		if(!proyectoService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			Proyecto proyecto =proyectoService.findById(id).get();
			return new ResponseEntity<Proyecto>(proyecto,HttpStatus.OK);
		}
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody ProyectoDTO proyectoDTO){
		Optional<TipoPro> tipopro = tipoproService.findById(proyectoDTO.getIdTipoPro());
		Optional<Semestre> semestre = academicClient.getSemestreById(proyectoDTO.getIdSemestre());
		Optional<Escuela> escuela = academicClient.getEscuelaById(proyectoDTO.getIdEscuela());

		Proyecto proyecto = new Proyecto(proyectoDTO.getNombre(),proyectoDTO.getDescripcion(),proyectoDTO.getFechaini(),proyectoDTO.getFechafin(),
				proyectoDTO.getPpto(),proyectoDTO.getEstadopro(),tipopro.get(),semestre.get(),escuela.get());
		proyectoService.save(proyecto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody ProyectoDTO proyectoDTO){
		if(!proyectoService.existById(id)){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	    Optional<TipoPro> tipo = tipoproService.findById(proyectoDTO.getIdTipoPro());
	    Optional<Semestre> semestre = academicClient.getSemestreById(proyectoDTO.getIdSemestre());
		Optional<Escuela> escuela = academicClient.getEscuelaById(proyectoDTO.getIdEscuela());
		
	    Proyecto proyecto = proyectoService.findById(id).get();
	    proyecto.setNombre(proyectoDTO.getNombre());
	    proyecto.setDescripcion(proyectoDTO.getDescripcion());
	    proyecto.setFechaini(proyectoDTO.getFechaini());
	    proyecto.setFechafin(proyectoDTO.getFechafin());
	    proyecto.setPpto(proyectoDTO.getPpto());
	    proyecto.setEstadopro(proyectoDTO.getEstadopro());
	    proyecto.setTipopro(tipo.get());
	    proyecto.setSemestre(semestre.get());
	    proyecto.setEscuela(escuela.get());		
	    proyectoService.save(proyecto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if (!proyectoService.existById(id)) {
			return new ResponseEntity<>(HttpStatus.OK);  		
		}else {
			proyectoService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);  
		}	
	}
	
	@GetMapping("/exist/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable("id") int id) {
	    boolean exists = proyectoService.existById(id);
	    return new ResponseEntity<>(exists, HttpStatus.OK);
	}
}
