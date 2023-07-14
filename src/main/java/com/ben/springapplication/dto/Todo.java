package com.ben.springapplication.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	private String name;
	
	@Size(min=10, message="Enter minimum 10 characters")
	private String description;
	
	@Column(name="plan date")
	private LocalDate planDate;
	private Boolean status;

	public Todo(Integer id, String name, String description, LocalDate planDate, Boolean status) {
		this.id = id;
		this.name = name;
		this.planDate = planDate;
		this.status = status;
		this.description = description;
	}

	public Todo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getPlanDate() {
		return planDate;
	}

	public void setPlanDate(LocalDate planDate) {
		this.planDate = planDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", planDate=" + planDate + ", status=" + status + "]";
	}
	
	

}
