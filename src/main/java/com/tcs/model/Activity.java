package com.tcs.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//@Component
//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@NamedQuery(name="find_All_Activities",query="select a from Activity a")
@NamedQuery(name="find_All_ActivitiesWithWhere",query="select a from Activity a where id= :id")
public class Activity {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	private String duration;
	private Date activity_date;
	
	@CreationTimestamp
	private LocalDateTime created_date;
	
	@UpdateTimestamp
	private LocalDateTime lastupdated_date;
	
	
	public Activity(){
		
	}
	
	
	
	public Activity(String description, String duration) {
		super();
		this.description = description;
		this.duration = duration;
	}


	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Date getActivity_date() {
		return activity_date;
	}



	public void setActivity_date(Date activity_date) {
		this.activity_date = activity_date;
	}
	
	public String toString() {
		
		return "Activity ["+this.id+","+this.description+","+this.duration+" ] \n ";
		
	}



	

	
	
}
