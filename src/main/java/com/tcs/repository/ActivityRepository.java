package com.tcs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcs.model.Activity;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

//	List<Activity> findAllActivities();
//	Activity findActivityById(Integer id);

}