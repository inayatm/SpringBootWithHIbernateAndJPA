package com.tcs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcs.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

//	List<Activity> findAllActivities();
//	Activity findActivityById(Integer id);

}