package com.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(	name = "teachers")
public class Teachers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String hourCost;
	
	@NotBlank
	@Size(max = 100)
	private String fullName;
	
	@NotBlank
	@Size(max = 100)
	private String cpfOrCnpj;
	
	@NotBlank
	@Size(max = 100)
	private String email;
	
	@NotBlank
	@Size(max = 20)
	private String whatsApp;
	
	@NotBlank
	@Size(max = 600)
	private String description;
	
	@NotBlank
	@Size(max = 500)
	private String linkPhoto;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_id")
	private List<Schedules> schedules;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_id")
	private List<Discipline> discipline;
}
