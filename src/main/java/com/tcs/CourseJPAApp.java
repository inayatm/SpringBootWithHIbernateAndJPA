package com.tcs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.jdbc.CourseJPADao;
import com.tcs.model.Course;


//@SpringBootApplication
public class CourseJPAApp implements CommandLineRunner {

	@Autowired
	CourseJPADao courseJpadao;
	
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	
	public static void main(String[] args) {
		SpringApplication.run(CourseJPAApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("\n Find course by id : "+courseJpadao.findByid(1002));
		
		Course course=new Course();
		course.setName("Java 8");
		course.setDuration("28min");
	   
		log.info("\n Inserting Course : "+courseJpadao.insertCourse(course));
		
		course.setId(1003);
		course.setName("java8 in 28 min");
		
		log.info("Update Course by id 1003 "+courseJpadao.updateCourse(course));
		
		courseJpadao.deleteCourseById(1002);
		log.info("Deleted Activity 1002 ");

		log.info("All activities  : "+courseJpadao.findAllCourses());
		

		courseJpadao.playingWithEntityManager();
		
		courseJpadao.findCourseWithPagination();
			
		
	}
	
	
	

}
