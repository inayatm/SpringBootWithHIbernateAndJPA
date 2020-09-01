package com.tcs;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import com.tcs.client.ActivityClient;
import com.tcs.model.Activity;

public class ActivityClientTest {
	
	@Test
	public void doesActivityExistById() {
		
		ActivityClient activityClient=new ActivityClient();
		Response activity=activityClient.getActivityByid(1);
		
		assertNotNull(activity);
		
	}
	
 	@Test
	public void testCreateActivtiy() {
		
		ActivityClient client=new ActivityClient();
		
		Activity activity=new Activity("workout","20min");
		Response response=client.createActivity(activity);
		assertNotNull(response);
		
	}
	
		
	@Test
	public void getAllActivities() {
		ActivityClient client=new ActivityClient();
		List<Activity> activities=client.getAllActivity();
		System.out.println(activities);
		assertNotNull(activities);
		
	}
	

}
