package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.models.Teachers;
import com.models.DTO.TeacherDTO;
import com.services.TeacherDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
/**
 * Define as rotas da classe Teachers.
 */
	@Autowired
	TeacherDetailsImpl teacherDetailsImpl;
	/**
	 * Define as rotas para salvar e buscar professores. 
	 * @param teacherDTO
	 * @return 
	 */
	
	@PostMapping("/save")
	public ResponseEntity<Teachers> save(@RequestBody TeacherDTO teacherDTO) {		
		return new ResponseEntity<>(teacherDetailsImpl.save(teacherDTO), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Teachers>> find() {		
		return new ResponseEntity<>(teacherDetailsImpl.findAll(), HttpStatus.OK);
	}
	
	/**
	 * Verifica a qualificação do professor pela quantidade de estrelas.
	 * @param id
	 * @param stars
	 * @return Quantidade de estrelas
	 */
	@PutMapping("/star/{id}")
	public ResponseEntity<Teachers> star (@PathVariable("id") Long id,
			@RequestParam ("stars") Integer stars) {		
		return new ResponseEntity<>(teacherDetailsImpl.updateStar(id, stars), HttpStatus.OK);
		
	}
}