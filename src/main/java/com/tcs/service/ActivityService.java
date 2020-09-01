package com.tcs.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.model.Activity;
import com.tcs.repository.ActivityRepository;

@Service
public class ActivityService {
	
	Logger log =LoggerFactory.getLogger(ActivityService.class);
	
	@Autowired
	ActivityRepository activityRepo;
	
	
	List<Activity> defaultacitivityList=new ArrayList<>(Arrays.asList(new Activity()));
	
	 public List<Activity> getAllActivities() {
		
		ArrayList<Activity> acitivityList=(ArrayList<Activity>)activityRepo.findAll();
		return acitivityList.isEmpty()?defaultacitivityList:acitivityList;
	}
	 
	public Activity createActivities(String description,String duration) {
		
		Activity activity=new Activity();
		activity.setDescription(description);
		activity.setDuration(duration);
		log.info(activity.getDescription());
		log.info(activity.getDuration());
		return activityRepo.save(activity);
		
	}
	
	
	
	public Activity getActivityById(Integer id) {
		log.info("Activity id " +id);
		//return activityRepo.findById(id).isPresent()?activityRepo.findById(id).get():defaultacitivityList.get(0);
		Activity activity=null;
		try {
			
		  activity=activityRepo.findById(id).get();
			
		  }catch(NoSuchElementException exception) {
			  throw new RuntimeException(id+" Not found!!");
			
		}
		
		return activity;
	}
	
	
	
	public Activity deleteActivity(int id) {
		log.info("Activity Deleted Successfully");
		Optional<Activity> activity=activityRepo.findById(id);
		activity.ifPresent(a->{activityRepo.deleteById(id);});
		return  activity.get();
	}
	
	
	

}
