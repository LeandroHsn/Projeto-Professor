package com.models.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;

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
	private String hourCost;
	private String fullName;
	private String cpfOrCnpj;
	private String email;
	private String whatsApp;
	private String linkPhoto;
	private String description;
	private String orderBy;
	
	
	@Override
    public Predicate toPredicate(Root<Teachers> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (orderBy != null && !orderBy.equals("asc")) {
            String[] orders = orderBy.split(";");

            for (Object order : orders) {
                String cbOrder = order.toString();
                String[] cbOrders = cbOrder.split(",");

                Expression<Object> expression = cbOrders[0].equals("approved") ? root.get("approved") : root.get(cbOrders[0]);
                if (cbOrders[1].equals("asc")) {
                    query.orderBy(cb.asc(expression));
                } else {
                    query.orderBy(cb.desc(expression));
                }

            }
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
		
}


