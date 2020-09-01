//package com.tcs.repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.tcs.model.Activity;
//
//@Component
//public class ActivityResourceRepoStub implements ActivityRepository {
//	
//	Logger log=LoggerFactory.getLogger(ActivityResourceRepoStub.class);
//	
//	
//
//	
//	
//	
//	
//	
////	private List<Activity> activities;
////	
////	@Override
////	public List<Activity> findAllActivities() {
////		
////		Activity activity=new Activity();
////		Activity activity1=new Activity();
////		Activity activity2=new Activity();
////		
////		activities=new ArrayList<>();
////		
////		activity.setId(1234);
////		activity.setDescription("workout");
////		activity.setDuration("2h");
////	
////		activity1.setDescription("Cardio");
////		activity1.setDuration("30min");
////		activity1.setId(5678);
////		
////		activity2.setDescription("Treadmill");
////		activity2.setDuration("30min");
////		activity2.setId(1234);
////		
////		
////		
////		activities.add(activity);
////		activities.add(activity1);
////		activities.add(activity2);
////			
////		return activities;
////		
////	}
////	
////	@Override
////	public Activity findActivityById(Integer id) {
////		
////		log.info("Reqeuste id is :"+ id);
////		
////		Activity ac=(Activity)findAllActivities().get(id);
////		
////		log.info("activity by id: "+ac);
////		
////		return ac;
////		
////		
////		
////	}
//	
//	
//
//}
