package com.tcs;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.jdbc.CourseJPADao;
import com.tcs.repository.JPQLStudentRepository;


@SpringBootApplication
public class JPQLApp implements CommandLineRunner {

	@Autowired
	JPQLStudentRepository stdRepo;
	
	@Autowired
	CourseJPADao courseJpadao;
	
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	
	public static void main(String[] args) {
		SpringApplication.run(JPQLApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	

		//List<Course> courses=courseJpadao.findAllCourses();
		
		//stdRepo.registerMultipleCoursesForStudent(courses, 1002L);
		
		 stdRepo.getCoursesWhichDoesNotRegisteredByAnyStudent();
		 
		 List ls=new ArrayList();
		 
		 ls.add("inaayth");
		 ls.add(1);
		 
		 
		
	}
	
	
	

}
