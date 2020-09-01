package com.tcs.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQuery(name="find_All_Courses",query="select a from Course a")
@NamedQuery(name="find_All_CourseWithWhere",query="select a from Course a where id= :id")
public class Course {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String duration;
	
	@CreationTimestamp
	private LocalDateTime created_date;
	
	@UpdateTimestamp
	private LocalDateTime lastupdated_date;
	
	
	@OneToMany(mappedBy = "course")
	private List<Review> reviews;
	
	@ManyToMany(mappedBy="courses",fetch = FetchType.EAGER)
	private List<Student> students=new ArrayList<>();
		
	public Course(){
		
	}
	
		
	public Course(String name, String duration) {
		this.name = name;
		this.duration = duration;
	}

	
	public void addStudent(Student student) {
		this.getStudents().add(student);
		//student.addCourse(this);
		
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



	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}





	public void addReview(Review review) {
		reviews.add(review);
	}


	public void remvoeReviews(Review review) {
		this.reviews.remove(review);

	}



	public List<Review> getReviews() {
		return reviews;
	}



	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	
	


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", duration=" + duration + ", created_date=" + created_date
				+ ", lastupdated_date=" + lastupdated_date + "]";
	}
	
	
	
	
}
