package com.bezkoder.spring.security.postgresql.security.services;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.security.postgresql.models.Discipline;
import com.bezkoder.spring.security.postgresql.models.Teacher;
import com.bezkoder.spring.security.postgresql.repository.DisciplineRepository;
import com.bezkoder.spring.security.postgresql.repository.TeacherRepository;

@Service
public class DisciplineDetailsImpl  {	
	
	 @Autowired()
	 DisciplineRepository disciplineRepository;


	  @Transactional
		public void save(String discipline) {
			try {
				
				if (!discipline.isEmpty()) {
					Discipline disciplineModel = new Discipline();
					disciplineModel.setDiscipline(discipline);
					disciplineRepository.save(disciplineModel);
				} else {
					throw new ValidationException("Campo "+discipline+ "nulo.");
				}
				
			} catch (Exception e) {
				throw new ValidationException("Campo "+discipline+ "nulo.");
			}		
			
		}

}
