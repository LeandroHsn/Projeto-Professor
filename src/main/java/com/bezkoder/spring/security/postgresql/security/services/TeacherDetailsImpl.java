package com.bezkoder.spring.security.postgresql.security.services;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.security.postgresql.models.Teacher;
import com.bezkoder.spring.security.postgresql.repository.TeacherRepository;

@Service
public class TeacherDetailsImpl  {	
	
	 @Autowired()
	 TeacherRepository teacherRepository;


	  @Transactional
		public void save(String hora) {
			try {
				
				if (!hora.isEmpty()) {
					Teacher teacher = new Teacher();
					teacher.setHourCost(hora);
					teacherRepository.save(teacher);
				} else {
					throw new ValidationException("Campo "+hora+ "nulo.");
				}
				
			} catch (Exception e) {
				throw new ValidationException("Campo "+hora+ "nulo.");
			}		
			
		}

}
