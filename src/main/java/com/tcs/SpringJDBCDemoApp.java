package com.tcs;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tcs.jdbc.ActivityJDBCDao;
import com.tcs.model.Activity;

//@SpringBootApplication
public class SpringJDBCDemoApp implements CommandLineRunner {

	@Autowired
	ActivityJDBCDao activityJdbcdao;
	
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJDBCDemoApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("All activities  {}"+activityJdbcdao.findAllActvities());
		log.info("Find Activity by id {}"+activityJdbcdao.findByid(1001));
		log.info("Update Activity by id {}"+activityJdbcdao.updateActivityById(1001));
		log.info("Delete Activity by id {}"+activityJdbcdao.deleteActiviyById(1002));
			
		Activity activity=new Activity();
		activity.setId(1005);
		activity.setDescription("Biceps");
		activity.setDuration("20min");
	    activity.setActivity_date(new Date());
		log.info("Inserting  Activity 1005 {}"+activityJdbcdao.insertActivity(activity));
		
		
		
		
		
	}

}
