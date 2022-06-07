package com.bezkoder.spring.security.postgresql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSecurityPostgresqlApplicationTests {

  @Test
  public void contextLoads() {
  }

  /*
  @Test
  public void testReturnSaveTeacher() {
	  

	    TeacherDetailsImpl teDetailsImpl;
	    
	    Schedules schedules = Schedules.builder()
	    		.dayWeek("Segunda-feira")
	    		.initialDate("07")
	    		.finalDate("11")
	    		.teachers(null)
	    		.build();
	    
	    Discipline discipline = Discipline.builder()
	    		.discipline("Teste")
	    		.flagStandard(1)
	    		.teachers(null)
	    		.build();
	    
	    List<Schedules> schedulesList = new ArrayList<Schedules>();	    
	    schedulesList.add(schedules);
	    
	    List<Discipline> disciplineList = new ArrayList<Discipline>();	    
	    disciplineList.add(discipline);
	    
	    TeacherDTO teacher = TeacherDTO.builder()
				.hourCost("10")
				.fullName("Testonildo")
				.cpfOrCnpj("130.408.666.68")
				.email("testonildo@gmail.com")
				.whatsApp("7777-7777")
				.linkPhoto("testonildofoto.com.br")
				.schedules(schedulesList)
				.description("Prazer testonildo")
				.disciplines(disciplineList)
				.build();

	    assertThrows(teDetailsImpl.save(teacher), Teachers.class) ;
  }*/
}