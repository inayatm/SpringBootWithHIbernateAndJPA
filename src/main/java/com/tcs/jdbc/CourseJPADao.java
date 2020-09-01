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

/* Generally you will use @Trasactional on the code which performs business logic
 * 
 * 
 * */


@Repository
@Transactional
public class CourseJPADao {
	
	//Connection to databse
	@PersistenceContext
	EntityManager entityManager;
	
	Logger log=LoggerFactory.getLogger(CourseJPADao.class);
	
	
	public Course findByid(Integer id) {
		
		return entityManager.find(Course.class,id);
	}
	
	
	public Course updateCourse(Course course){
		
		return entityManager.merge(course);
	}
	
	public Course insertCourse(Course course){
		
		return entityManager.merge(course);
		
		 //entityManager.persist(course);  //returns void
	}
	
	public void deleteCourseById(Integer id){
		
		Course activity=entityManager.find(Course.class,id);
		
		entityManager.remove(activity);
		
	}
	
	
	public List<Course> findAllCourses(){
		
		TypedQuery<Course> namedquery=entityManager.createNamedQuery("find_All_Courses",Course.class);
		return namedquery.getResultList();
	}
	
	
	public void playingWithEntityManager() {
		
		Course course=new Course("Spring Boot","3h");
		
		entityManager.persist(course);
		
		course.setDuration("updated duration");
		
		Course course2=findByid(1001);
		
		course2.setName("spring boot updated");
		
		
		
	}
	
	
	public void findCourseWithPagination(){
		
		  TypedQuery<Course> query=entityManager.createQuery("FROM Course", Course.class);
		   
		  query.setFirstResult(0);
		  query.setMaxResults(10);
		  
			
		 log.info("findCourseWithPagination recored  size  :  => {} "+query.getResultList().size());
			
			
		}

	
	
	
}
