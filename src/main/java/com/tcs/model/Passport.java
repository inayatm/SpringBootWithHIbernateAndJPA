package com.tcs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String number;
	
	//For Bidirectional Mapping
	
	/* IN Bidirectional mapping student id column will be 
	 * 
	 * */
	
	
	//mappedBy is to declare non-owning table. To remove the duplicate column ids in student and password tables.
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
	private Student student;

	public Passport() {
		
	}
	
	public Passport(String number) {
		this.number=number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
		
	
	
	

}
