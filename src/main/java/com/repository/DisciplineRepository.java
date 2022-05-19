package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

}
