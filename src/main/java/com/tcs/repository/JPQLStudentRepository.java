package com.tcs.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class JPQLStudentRepository {
	
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	EntityManager em;
	
	
		
	/* Data base query
	 * 
	 * SELECT * FROM COURSE  WHERE ID  
	 * NOT IN (SELECT COURSE_ID FROM STUDENT_COURSE) 
	 * 
	
	*/
	
	
	public void getCoursesWhichDoesNotRegisteredByAnyStudent() {
		
		Query query=em.createQuery("SELECT c from Course c where c.students is empty ");
		
		log.info("Corueses without students : {}",query.getResultList());		
		
		
	}
	
	/*
	 * SELECT * from STUDENT_COURSE
	 * WHERE ( SELECT STUDENT 
	 * 
	 * */

   public void getCourses_With_atleast_2_Students() {
	   
	Query query=em.createQuery("SELECT c from Course c where c.students > =2 ");
		
	log.info("Corueses without students : {}",query.getResultList());		
	

	
   }

}