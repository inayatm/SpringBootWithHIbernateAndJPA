package com.tcs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.jdbc.CourseJPADao;
import com.tcs.jdbc.StudentJPADao;
import com.tcs.model.Course;
import com.tcs.model.FullTimeEmployee;
import com.tcs.model.PartTimeEmployee;
import com.tcs.model.Passport;
import com.tcs.model.Review;
import com.tcs.model.Student;
import com.tcs.repository.EmployeeRepository;


//@SpringBootApplication
public class EmployeeJPAApp implements CommandLineRunner {

	@Autowired
	EmployeeRepository empRepo;
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeJPAApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	

		//Insert employee
		
		 FullTimeEmployee fulltimeEmployee=new FullTimeEmployee("mark",new BigDecimal(10000));
		 PartTimeEmployee parttimeEmployee=new PartTimeEmployee("weines",new BigDecimal(10000));
		
		
		 empRepo.insertEmployee(fulltimeEmployee);
		 empRepo.insertEmployee(parttimeEmployee);
		 
		 //Retrieve employees
		 
		 log.info("All employee s \n {}",empRepo.getAllEmployees());
		

		
	}
	
	
	

}
