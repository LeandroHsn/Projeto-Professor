package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Teachers;

@Repository
public interface TeacherRepository extends JpaRepository<Teachers, Long> {

}
