package com.tcs.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tcs.model.Activity;

public class ActivityClient {
	
	private Client client;
	
	private WebTarget target;
	
	
	public ActivityClient() {
		
		client=ClientBuilder.newClient();
		target=client.target("http://localhost:8080/exercise-services/");
	}
	
	public Response getActivityByid(int id) {
		
		//Activity activitResponse=target.path("activities/"+id).request().get(Activity.class);
		
		Response activitResponse=target.path("/activities/"+id).request(MediaType.APPLICATION_JSON).get(Response.class);
	
		if(activitResponse.getStatus()!=200) {
			throw new RuntimeException(activitResponse.getStatus() +" :There is an error at server.");
		}
		//return activitResponse.readEntity(Activity.class);
		return activitResponse;
    	}
	
	
	public Activity deleteActivityByid(int id) {
		
		Activity activitResponse=target.path("/deleteActivity/"+id).request().get(Activity.class);
		
		return activitResponse;
	}
	
	public List<Activity> getAllActivity() {
		
		
		List<Activity> activitResponse=target.path("/activities").request().get(new GenericType<List<Activity>>(){});
		
		return activitResponse;
	}

	public Response createActivity(Activity activity) {
		
		return target.path("activities/activity").request().post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
	}
	

}
