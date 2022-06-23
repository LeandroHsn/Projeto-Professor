package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.models.Panel;
import com.models.Teachers;
import com.models.DTO.TeacherDTO;
import com.models.filter.TeacherFilter;
import com.repository.PanelRepository;
import com.repository.TeacherRepository;

@Service
public class TeacherDetailsImpl  {	
	
	 @Autowired()
	 TeacherRepository teacherRepository;
	 
	 @Autowired()
	 PanelRepository panelRepository;


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
						.linkPhoto(dto.getLinkPhoto())
						.schedules(dto.getSchedules())
						.description(dto.getDescription())
						.discipline(dto.getDisciplines())
						.stars(0)
						.verify(0)
						.approved(0)
						.build();
				
				List<Teachers> teachers = new ArrayList<>();
				teachers.add(teacher);
				
				Panel panel = Panel.builder()
						.teachers(teachers)
						.teacherApproved(0)
						.build();
				
				teacherRepository.save(teacher);
				panelRepository.save(panel);
				
				return new Teachers();
				
			} catch (Exception e) {
				throw new ValidationException("Erro: " + e.getMessage());
			}				
		}


	private void validateTeacher(TeacherDTO dto) {
		
		try {			
			if (dto.getCpfOrCnpj() == null) {
				throw new ValidationException("CPF ou CNPJ inválido.");
			}
			
			if (dto.getCpfOrCnpj() != null) {
				List<Teachers> teachers = teacherRepository.findAll(); //Ajuste temporário pois o JPA não está funcionando				
				for (Teachers teacher : teachers) { 
					if (teacher.getCpfOrCnpj().equalsIgnoreCase(dto.getCpfOrCnpj())) {
						throw new ValidationException("CPF/CNPJ registrado, edite seus dados ou utilize outro CPF/CNPJ.");
					}
				}			
			
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
			if (dto.getDisciplines() == null) {
				throw new ValidationException("Disciplina inválido.");
			}
			if (dto.getLinkPhoto() == null) {
				throw new ValidationException("Link da foto inválido.");
			}
		} catch (Exception e) {
			throw new ValidationException("Erro: " + e.getMessage());
		}	

	}
	
	public Teachers updateStar(Long id, Integer stars) {
		try {
			
			if(id == null) {
				throw new ValidationException("ID não encontrado" );
			}
			
			Optional<Teachers> optional = teacherRepository.findById(id);
			
			if(!optional.isPresent()) {
				throw new ValidationException("ID não encontrado" );
			} 		
			
			Teachers teacher = optional.get();
			
			teacher.setStars(stars);
			return teacherRepository.save(teacher);
			
		} catch (Exception e) {
			throw new ValidationException("Erro: " + e.getMessage());
		}				
		
	}
	
	@Transactional
	public List<Teachers> findAll(TeacherFilter teFilter, Integer pageNumber, Integer pageSize) {		
		try {		
			Pageable pageable;
			List<Teachers> teachers;
			List<Teachers> teachersVeri = new ArrayList<Teachers>();
			
			if (pageNumber != null && pageNumber > 0 && pageSize != null) {
				pageable = PageRequest.of(pageNumber - 1, pageSize);
				teachers = new ArrayList<>(teacherRepository.findAll(teFilter, pageable).getContent());

			} else {
				teachers = teacherRepository.findAll(teFilter);
			}
			
			for (Teachers teachersVerify : teachers) {
				if (teachersVerify.getVerify() == 1) {
					teachersVeri.add(teachersVerify);
				}
			}
			
			for (Teachers teachersVerify : teachers) {
				if (teachersVerify.getVerify() == 0) {
					teachersVeri.add(teachersVerify);
				}
			}
			
			return teachersVeri;
		} catch (Exception e) {
			throw new ValidationException("Erro: " + e.getMessage());
		}				
	}
	
	public Teachers verified(Long id) {
		try {
			
			if(id == null) {
				throw new ValidationException("ID não encontrado" );
			}	
			
			Optional<Teachers> optional = teacherRepository.findById(id);
			
			if(!optional.isPresent()) {
				throw new ValidationException("ID não encontrado" );
			} 	
			
			Teachers teacher = optional.get();	
						
			teacher.setVerify(1);
			return teacherRepository.save(teacher);
			
		} catch (Exception e) {
			throw new ValidationException("Erro: " + e.getMessage());
		}				
	}
	
	public Teachers notVerified(Long id) {
		try {			
			if(id == null) {
				throw new ValidationException("ID não encontrado" );
			}	
			
			Optional<Teachers> optional = teacherRepository.findById(id);
			
			if(!optional.isPresent()) {
				throw new ValidationException("ID não encontrado" );
			} 	
			
			Teachers teacher = optional.get();	
						
			teacher.setVerify(0);
			return teacherRepository.save(teacher);
			
		} catch (Exception e) {
			throw new ValidationException("Erro: " + e.getMessage());
		}				
	}
}
