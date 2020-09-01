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

import com.tcs.model.Course;
import com.tcs.repository.CourseRepository;

@Service
public class CourseService {
	
	Logger log =LoggerFactory.getLogger(CourseService.class);
	
	@Autowired
	CourseRepository courseRepo;
	
	List<Course> defaultCourseList=new ArrayList<>(Arrays.asList(new Course()));
	
	
	  public List<Course> getAllActivities() {
		
		ArrayList<Course> acitivityList=(ArrayList<Course>)courseRepo.findAll();
		
		
		return acitivityList.isEmpty()?defaultCourseList:acitivityList;
		
	}
	
	
	public Course createCourse(String name,String duration) {
		
		Course course=new Course();
		course.setName(name);
		course.setDuration(duration);
		log.info(course.getName());
		log.info(course.getDuration());
		return courseRepo.save(course);
		
	}
	
	
	
	public Course getCourseById(Integer id) {
		log.info("Course id " +id);
		//return activityRepo.findById(id).isPresent()?activityRepo.findById(id).get():defaultacitivityList.get(0);
		Course course=null;
		try {
			
		  course=courseRepo.findById(id).get();
			
		  }catch(NoSuchElementException exception) {
			  throw new RuntimeException(id+" Not found!!");
			
		}
		
		return course;
	}
	
	
	
	public Course deleteCourse(int id) {
		log.info("course Deleted Successfully");
		Optional<Course> course=courseRepo.findById(id);
		course.ifPresent(a->{courseRepo.deleteById(id);});
		return  course.get();
	}
	
	
	

}
