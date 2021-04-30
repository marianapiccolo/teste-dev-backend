package com.olisaude.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olisaude.dev.model.healthProblems;

public interface healthProblemsRepository extends JpaRepository<healthProblems, Long> {
	public List<healthProblems> findAllByNameContainingIgnoreCase(String name);

}
