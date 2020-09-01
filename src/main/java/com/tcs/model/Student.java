package com.tcs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "find_All_students",query = "SELECT s from Student s")
public class Student {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	/*
	 * -->  **ToOne is by default Eager fetching --eg: OneToOne is eager fetching
	 * --> **ToMany is by default Lazy fetching -- eg:oneToMany is lazy fetching
	 * */
	
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="STUDENT_COURSE",
	joinColumns = @JoinColumn(name="STUDENT_ID"),
	inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
	private List<Course> courses=new ArrayList<>();

	public Student() {
		
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	
	public void addCourse(Course course) {
		courses.add(course);
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
	return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
//	public List<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}	
}