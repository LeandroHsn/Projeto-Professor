package com.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Teachers;
import com.models.DTO.TeacherDTO;
import com.repository.TeacherRepository;

@Service
public class TeacherDetailsImpl  {	
	
	 @Autowired()
	 TeacherRepository teacherRepository;

	 @Transactional
	 public Teachers save(TeacherDTO dto) {
		try {				
				validateTeacher(dto);
				
				Teachers teacher = Teachers.builder()
						.hourCost(dto.getHourCost())
						.fullName(dto.getFullName())
						.cpfOrCnpj(dto.getCpfOrCnpj())
						.email(dto.getEmail())
						.whatsApp(dto.getWhatsApp())
						.schedules(dto.getSchedules())
						.description(dto.getDescription())
						.discipline(dto.getDisciplines())
						.build();
				
				teacherRepository.save(teacher);
				
				return new Teachers();
				
			} catch (Exception e) {
				throw new ValidationException("Erro: " + e.getMessage());
			}				
		}


	private void validateTeacher(TeacherDTO dto) {
		
		if (dto.getCpfOrCnpj() == null) {
			throw new ValidationException("CPF ou CNPJ inválido.");
		}
		if (dto.getDescription() == null) {
			throw new ValidationException("Descrição inválida.");
		}
		if (dto.getEmail() == null) {
			throw new ValidationException("E-mail inválido.");
		}
		if (dto.getFullName() == null) {
			throw new ValidationException("Nome inválido.");
		}
		if (dto.getHourCost() == null) {
			throw new ValidationException("Custo por hora inválido.");
		}
		if (dto.getSchedules() == null) {
			throw new ValidationException("Horários inválido.");
		}
		if (dto.getWhatsApp() == null) {
			throw new ValidationException("WhatsApp inválido.");
		}
		if (dto.getDisciplines() == null) {
			throw new ValidationException("Disciplina inválido.");
		}
	}
	
	@Transactional
	public List<Teachers> findAll() {		
		try {			
			List<Teachers> teachers = teacherRepository.findAll();
			return teachers;
		} catch (Exception e) {
			throw new ValidationException("Erro: " + e.getMessage());
		}				
	}

}
