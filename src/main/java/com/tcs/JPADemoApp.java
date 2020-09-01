package com.tcs;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.tcs.jdbc.ActivityJPADao;
import com.tcs.model.Activity;


//@SpringBootApplication
public class JPADemoApp implements CommandLineRunner {

	@Autowired
	ActivityJPADao activityJpadao;
	
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	
	public static void main(String[] args) {
		SpringApplication.run(JPADemoApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("\n Find Activity by id : "+activityJpadao.findByid(1001));
		
		Activity activity=new Activity();
		activity.setDescription("Biceps");
		activity.setDuration("20min");
	    activity.setActivity_date(new Date());
		
		log.info("\n Inserting Activity 1 : "+activityJpadao.insertActivity(activity));
		
		activity.setId(1003);
		activity.setDescription("triceps");
		
		log.info("Update Activity by id 1003 "+activityJpadao.updateActivity(activity));
		
		activityJpadao.deleteActivityById(1002);
		log.info("Deleted Activity 1002 ");

		log.info("All activities  : "+activityJpadao.findAllActvities());
		

		activityJpadao.playingWithEntityManager();
		
		activityJpadao.findActivityWithPagination();
			
		
	}
	
	
	

}
