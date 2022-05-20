package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Discipline;
import com.repository.DisciplineRepository;

@Service
public class DisciplineDetailsImpl  {	
	
	@Autowired()
	DisciplineRepository disciplineRepository;
	
	@Transactional
	public List<Discipline> findAll() {
		
		try {			
			List<Discipline> disciplines = disciplineRepository.findAll();
			List<Discipline> cleanList = new ArrayList<Discipline>();
			
			for (Discipline discipline : disciplines) {
				if (discipline.getFlagStandard() != null) {
					cleanList.add(discipline);					
				} 				
			} 			
			return cleanList;
		} catch (Exception e) {
			throw new ValidationException("Erro: " + e.getMessage());
		}				
	}
}
