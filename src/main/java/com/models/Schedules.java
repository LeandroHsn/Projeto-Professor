package com.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(	name = "schedules")
public class Schedules {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String dayWeek;
	
	@NotBlank
	@Size(max = 5)
	private Integer initialDate;
	
	@NotBlank
	@Size(max = 5)
	private Integer finalDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Teachers teachers;
}
