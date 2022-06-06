package com.models.DTO;

import java.util.List;

import com.models.Discipline;
import com.models.Schedules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

	private String hourCost;
	private String fullName;
	private String cpfOrCnpj;
	private String email;
	private String whatsApp;
	private String linkPhoto;
	private String description;
	private List<Schedules> schedules; 
	private List<Discipline> disciplines;
		
}


