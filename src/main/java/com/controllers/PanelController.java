package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.Panel;
import com.services.PanelDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/panel")
public class PanelController {


	@Autowired
	PanelDetailsImpl  panelDetailsImpl;
	/**
	 * Define as rotas de verificação (se aprovado ou não).
	 * @param id
	 * @return Usuário aprovado ou não.
	 */
	@PutMapping("/approve/{id}")
	public ResponseEntity<Panel> approve (@PathVariable("id") Long  id) {		
		return new ResponseEntity<>(panelDetailsImpl.approve(id), HttpStatus.OK);
	}
	
	@PutMapping("/disapprove/{id}")
	public ResponseEntity<Panel> disapprove (@PathVariable("id") Long id) {		
		return new ResponseEntity<>(panelDetailsImpl.disapprove(id), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Panel>> find() {		
		return new ResponseEntity<>(panelDetailsImpl.findAll(), HttpStatus.OK);
	}
}