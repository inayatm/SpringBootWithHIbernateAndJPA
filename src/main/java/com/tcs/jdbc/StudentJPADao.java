package com.tcs.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tcs.model.Course;
import com.tcs.model.Passport;
import com.tcs.model.Review;
import com.tcs.model.Student;

/* Generally you will use @Trasactional on the code which performs business logic
 * 
 * 
 * */


@Repository
@Transactional
public class StudentJPADao {
	
	//Connection to databse
	@PersistenceContext
	EntityManager entityManager;
	
	Logger log=LoggerFactory.getLogger(StudentJPADao.class);
	
	
	public Student findByid(int id) {
		
		return entityManager.find(Student.class,id);
	}
	
	
	public Student updateStudent(Student student){
		
		return entityManager.merge(student);
	}
	
	public Student insertStudent(Student student){
		
		return entityManager.merge(student);
		
		 //entityManager.persist(course);  //returns void
	}
	
	public void deleteStudentById(int id){
		
		Student student=entityManager.find(Student.class,id);
		
		entityManager.remove(student);
		
	}
	
	
	public List<Student> findAllStudents(){
		log.info("findAllStudents being called");
		TypedQuery<Student> namedquery=entityManager.createNamedQuery("find_All_students",Student.class);
		return namedquery.getResultList();
	}
	
	
	public void saveStudentWithPassport() {
		
		Passport passport=new Passport("E19803456");
		

		Student std=new Student("iko uwais");
	
		passport.setStudent(std);
		
		entityManager.persist(passport);
		
		std.setPassport(passport);
		
		entityManager.persist(std);
		
		
		
	}
	
	
	
	public void findStudentWithPagination(){
		
		  TypedQuery<Student> query=entityManager.createQuery("FROM Student", Student.class);
		   
		  query.setFirstResult(0);
		  query.setMaxResults(10);
		  
			
		 log.info("findCourseWithPagination recored  size  :  => {} "+query.getResultList().size());
			
			
		}

	
	public void fetchStudentWithPassportDetails(Long id) {
		
		Student std=entityManager.find(Student.class, id);
		log.info("Student Name "+std.getName() +" and Passort Number "+std.getPassport().getNumber());
		
		
	}
	
	public void addReviewsForTheCourse(Integer courseId,List<Review> reviews) {
		
		log.info("Adding reviews for the course");
		
		Course course=entityManager.find(Course.class, courseId);
		
		for(Review review:reviews) {
			course.addReview(review);
			review.setCourse(course);
			entityManager.persist(review);
		}
		
		
	}
	
	public List<Review> retrieveReviewsForCourse(Integer courseId) {
		Course course=entityManager.find(Course.class,courseId);
		List<Review> reviews=course.getReviews();
		
		log.info("List of Review for the course  {}}"+course.getName());
		log.info("{} "+reviews);
		
		return reviews;
		
	}
	
	
	
	public void insertStudentAndCourse(Student student,Course course) {
		
		
		entityManager.persist(student);
		entityManager .persist(student.getPassport());
		entityManager.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		
		entityManager.persist(student);
		
		
	}
	
	
	
	
	
	public void registerMultipleCoursesForStudent(List<Course> courses,Long studentId) {
		
		Student student=entityManager.find(Student.class,studentId);
		
		for(Course course:courses) {
			
			//entityManager.persist(course);
			//entityManager.persist(student);
			
			course.addStudent(student);
			student.addCourse(course);

			entityManager.persist(student);
			 
		}
		
}
	
	
	public void registerCourseForStudent(Course course,Student student) {
		
		entityManager.persist(student);
		
		course.addStudent(student);
		student.addCourse(course);

		entityManager.persist(student);
		
}
	
	

	
	
}
