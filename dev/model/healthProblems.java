package com.olisaude.dev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

//Table Health Problems
@Entity
@Table(name = "healthProblems")
public class healthProblems {
	
	//Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//Name of health problem
	@NotNull
	private String name;
	
	//Degree of health problem
	@NotNull
	private int degreeProblem;
	
	//Score of person
	@NotNull
	private  double score;
	
	//Sum of degree problems of person
	private int sd;
	
	//Relationship between tables
	//Many health problems for a client
	@ManyToOne
	@JsonIgnoreProperties("healthProblems")
	private Client client;

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDegreeProblem() {
		return degreeProblem;
	}

	public void setDegreeProblem(int degreeProblem) {
		this.degreeProblem = degreeProblem;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getSd() {
		return sd;
	}

	public void setSd(int sd) {
		this.sd = sd;
	}

	
		
		
	}
	
	
	
	


