package com.tcs.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tcs.model.Activity;
import com.tcs.service.ActivityService;

@RestController
public class ActivityController {
	
	Logger log=LoggerFactory.getLogger(ActivityController.class);
    
	
	@Autowired
	ActivityService service;
	
	@Autowired
	ActivityController contoller;

	
	
	@GET
	@RequestMapping("/activities")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Activity> getActivities() {
		return service.getAllActivities();
		
	}
	
	@POST
	@RequestMapping("activities/activity")
	@Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody Activity addActivities(@RequestBody ObjectNode objectNode) {
			
		return service.createActivities(objectNode.get("description").textValue(), objectNode.get("duration").textValue());
		
	}
	
	
   
	@GET
	@RequestMapping("/activities/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActivityById(@PathVariable Integer id) {
		
		if(id==null || id>=100)
		return Response.status(Status.BAD_REQUEST).build();
	
		Activity activity=service.getActivityById(id);
		log.info("Activity with"+ id +": "+activity);
			
		if(activity==null || activity.getId()==null)
		return Response.status(Status.NOT_FOUND).build();
			
		
		return Response.ok().entity(activity).build();
	}
	
	@DELETE
	@RequestMapping("/deleteActivity/{id}")
	public Activity deleteActivity(@PathVariable int id) {
		log.info("Activity Deleted Successfully");
       return service.deleteActivity(id);
	}
	
	
	@Scheduled(cron ="0 * * * * MON-FRI")
	public void fetchDataDataIntoTable() {
	  
		System.out.println("Scheduler ran ");
		
	   service.getAllActivities().forEach(System.out::println);
	   
	   System.out.println("Done fetching...");

		}
}