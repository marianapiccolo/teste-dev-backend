package com.olisaude.dev.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

import com.olisaude.dev.model.Client;
import com.olisaude.dev.model.healthProblems;
import com.olisaude.dev.repository.ClientRepository;



@RestController
//url that the class will be accessed
@RequestMapping("/clients") 
//It accepts any origin
@CrossOrigin("*")
public class ClientController {
	
	Scanner ler = new Scanner (System.in);
	
	//All interface services will be accessed through the controller
	@Autowired
	private ClientRepository repository;
		
	@GetMapping //It shows the list of client
	public ResponseEntity<List<Client>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//Get by Id
	@GetMapping("/{id}") // Find by ID
	public ResponseEntity<Client> GetById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//Get by name of client
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Client>> GetByClient(@PathVariable String name) {
		return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(name));
	}
	
	//Post a new client
	@PostMapping
	public ResponseEntity<Client> postClient(@RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(client));
	}
	
	//Update a client
	@PutMapping
	public ResponseEntity<Client> putClient(@RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(client));
	}
	
	//Calculate the client's score
	public double Score(healthProblems healthProblems) {
		int sd = 0;
		sd = sd + healthProblems.getDegreeProblem();
		healthProblems.setScore((1/(1+Math.E -(-2.8+sd)))*100);
		return healthProblems.getScore();
	}
	
	//New list
	ArrayList<Double> listclients = new ArrayList<Double>();
	
	//Show the 10 clients with the highest health risk
	public void showTenClients(healthProblems healthProblems){
		listclients.add(healthProblems.getScore());
		Collections.sort(listclients,Collections.reverseOrder());
		 System.out.println("10 clients with the highest health risk:");
		for(int i =0;i < 10;i++) {
		    System.out.println(listclients.get(i));
		    System.out.println("Name: "+ Client.class.getName());
			System.out.println("Score: "+healthProblems.getScore());		
			}
	
}
}
	
