package com.tcs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.tcs.jdbc.ActivityJPADao;
import com.tcs.model.Activity;

@SpringBootTest
public class ActivityClientTestWithSpring {
	
	private Logger log=LoggerFactory.getLogger(ActivityClientTestWithSpring.class);
	
	@Autowired	
	ActivityJPADao activityJpadao;
	
	@Test
	public void findByIdTest() {
		log.info(activityJpadao.findByid(1001).getDescription());
		assertEquals("cardio", activityJpadao.findByid(1001).getDescription());
	}
	
	@Test
	@DirtiesContext   //test automatically insert the data after tested.
	public void deleteByIdTest() {
		activityJpadao.deleteActivityById(1003);
	
		assertNull(activityJpadao.findByid(1003));
		
		log.info("deleted id b y test: "+1003 );
		
	}
	
	
	@Test
	public void updateInsertActivityTest() {
		
		Activity activity=activityJpadao.findByid(1003);
		
		assertNotNull(activity);
		activity.setDescription("updated descirption");
		activityJpadao.updateActivity(activity);
		
		assertEquals("updated descirption", activityJpadao.findByid(1003).getDescription());
		
			
	}
	
	@Test
	@DirtiesContext
	public void playingWithEntityManagerTest() {
		
		activityJpadao.playingWithEntityManager();
	
		
	}
	

}
