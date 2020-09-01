package com.tcs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String rating;
	
	
	/*
	 * -->  **ToOne is by default Eager fetching --eg: OneToOne,ManyToOne is Eager fetching
	 * --> **ToMany is by default Lazy fetching -- eg:oneToMany,ManyToMany is Lazy fetching
	 * */
	
	
	@ManyToOne
	private Course course;

	public Review() {
		
	}

	
	
	public Review(String depricption, String rating) {
		this.description = depricption;
		this.rating = rating;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepricption() {
		return description;
	}

	public void setDepricption(String depricption) {
		this.description = depricption;
	}



	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", depricption=" + description + ", rating=" + rating + "]";
	}
	
	
	
	
	

	

}
	