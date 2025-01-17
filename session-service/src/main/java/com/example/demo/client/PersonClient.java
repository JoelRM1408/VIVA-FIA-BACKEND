package com.example.demo.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Tutor;

@FeignClient(name = "person-service")
public interface PersonClient {
	
	@GetMapping("apialumno/detalle/{id}")
    Optional<Alumno> getAlumnoById(@PathVariable("id") int id);
	
	@GetMapping("apitutor/detalle/{id}")
    Optional<Tutor> getTutorById(@PathVariable("id") int id);
	
}