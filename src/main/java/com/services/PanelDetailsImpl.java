package com.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Panel;
import com.models.Teachers;
import com.repository.PanelRepository;

@Service
public class PanelDetailsImpl  {	
	
	 @Autowired()
	 PanelRepository  panelRepository;
	
	@Transactional
	public List<Panel> findAll() {		
		try {			
			List<Panel> panels = panelRepository.findAll();
			return panels;
		} catch (Exception e) {
			throw new ValidationException("Erro: " + e.getMessage());
		}				
	}

	public Panel approve(Long id) {
		try {			
			if(id == null) {
				throw new ValidationException("ID não encontrado" );
			}
			
			Optional<Panel> optional = panelRepository.findById(id);
			
			if(!optional.isEmpty()) {
				
				Panel panel = optional.get();
				
				panel.setTeacherApproved(1);
				for (Teachers teacher: panel.getTeachers()) {
					teacher.setApproved(1);
				}
				return panelRepository.save(panel);
			} else {
				throw new ValidationException("ID não encontrado" );
			}
			
		} catch (Exception e) {
			throw new ValidationException("Erro: " + e.getMessage());
		}				
		
	}

	public Panel disapprove(Long id) {
		try {			
			if(id == null) {
				throw new ValidationException("ID não encontrado" );
			}
			
			Optional<Panel> optional = panelRepository.findById(id);
			
			if(!optional.isEmpty()) {
				
				Panel panel = optional.get();
				
				panel.setTeacherApproved(0);
				for (Teachers teacher: panel.getTeachers()) {
					teacher.setApproved(0);
				}
				return panelRepository.save(panel);
			} else {
				throw new ValidationException("ID não encontrado" );
			}
			
		} catch (Exception e) {
			throw new ValidationException("Erro: " + e.getMessage());
		}
	}
}
