package com.models.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;

import com.models.Discipline;
import com.models.Schedules;
import com.models.Teachers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherFilter implements Specification<Teachers> {

	private static final long serialVersionUID = 1L;
	private String dayWeek;
	private String discipline;
	private String orderBy;
	
	
	@Override
    public Predicate toPredicate(Root<Teachers> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
                
        if (dayWeek != null) {
            Join<Teachers, Schedules> schedules = root.join("schedules", JoinType.LEFT);
            predicates.add(cb.equal(schedules.get("dayWeek"), dayWeek));
        }
                
        if (discipline != null) {
            Join<Teachers, Discipline> disciplines = root.join("discipline", JoinType.LEFT);
            predicates.add(cb.equal(disciplines.get("discipline"), discipline));
        }
        
        return cb.and(predicates.toArray(new Predicate[0]));
    }
		
}


