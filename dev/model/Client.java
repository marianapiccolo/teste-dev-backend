package com.olisaude.dev.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

//Table Clients
@Entity
@Table(name = "clients") 
public class Client {

	//Id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; //id

	//Name of client
	@NotNull
	@Size(min = 5, max = 100)
	private String name;

	//Client's birth date
	@NotNull
	private String birthDate;

	//Client's gender
	@NotNull
	private String gender;

	//Client's health problem
	@NotNull
	@Size(min = 3, max = 50)
	private String healthProblem;

	// Date of creation
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	// Update 
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate = new java.sql.Date(System.currentTimeMillis());
	
	//Relationship between tables
	//A client may have more than one health problem
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("client")
	private List<healthProblems> healthProblems;

	
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHealthProblem() {
		return healthProblem;
	}

	public void setHealthProblem(String healthProblem) {
		this.healthProblem = healthProblem;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<healthProblems> getHealthProblems() {
		return healthProblems;
	}

	public void setHealthProblems(List<healthProblems> healthProblems) {
		this.healthProblems = healthProblems;
	}

	

}
