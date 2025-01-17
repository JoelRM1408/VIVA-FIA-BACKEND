package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion,Integer> {
	@Query(value = "SELECT * FROM SESION S WHERE S.PROYECTO_ID = ?1",nativeQuery = true)
	List<Sesion> findSesionbyProQueryNative(int idProyecto);
}
