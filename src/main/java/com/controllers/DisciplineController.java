package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.Discipline;
import com.services.DisciplineDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/discipline")
public class DisciplineController {

	@Autowired
	DisciplineDetailsImpl disciplineDetailsImpl;
	/**
	 * Define a rota para buscar todas as disciplinas.
	 * @return Lista de Disciplines
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Discipline>> find() {		
		return new ResponseEntity<>(disciplineDetailsImpl.findAll(), HttpStatus.OK);
	}

}
