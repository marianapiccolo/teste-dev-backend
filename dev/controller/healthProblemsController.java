package com.olisaude.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.olisaude.dev.model.healthProblems;
import com.olisaude.dev.repository.healthProblemsRepository;

@RestController
//It accepts any origin
@CrossOrigin(origins = "*", allowedHeaders = "*")
//url that the class will be accessed
@RequestMapping("/healthProblems")
public class healthProblemsController {
	
	//All interface services will be accessed through the controller
	@Autowired
	private healthProblemsRepository repository;
	
	//Get all health problems
	@GetMapping
	public ResponseEntity<List<healthProblems>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	//Get by Id
	@GetMapping("/{id}") // Find by ID
	public ResponseEntity<healthProblems> GetById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Get by name of health problem
	@GetMapping("/name/{name}")
	public ResponseEntity<List<healthProblems>> Get(@PathVariable String name) {
		return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(name));
	}
	
	//Post a new health problem
	@PostMapping
	public ResponseEntity<healthProblems> post(@RequestBody healthProblems name) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(name));
	}
	
	//Update the health problem
	@PutMapping
	public ResponseEntity<healthProblems> put(@RequestBody healthProblems name) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(name));
	}
	
	
	

}
