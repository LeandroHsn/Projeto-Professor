package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Panel;

@Repository
public interface PanelRepository extends JpaRepository<Panel, Long> {

}
