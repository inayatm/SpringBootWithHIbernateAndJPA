package com.tcs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.tcs.model.Activity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JPADemoApp.class)
public class NativeQueryTest {
	
	Logger log=LoggerFactory.getLogger(NativeQueryTest.class);

	@PersistenceContext
	EntityManager em;
	
	@Test
	public void findAllActivities(){
		
		Query query= em.createNativeQuery("SELECT * FROM Activity", Activity.class);
		List<Activity> listactivities= query.getResultList();
		
		log.info("All activities by Native query  => {} "+listactivities);		
	
		
	}
	
	@Test
	public void findAllActivitiesWithWhere(){
		
		Query query= em.createNativeQuery("FROM Activity where id= ? ", Activity.class);
		query.setParameter(1, 1010);
		
		List<Activity> listactivities= query.getResultList();
		
		log.info("All activities by Native query with where condition  => {} "+listactivities);		
	
		
	}
	
	@Test
	@Transactional
	public void updateActivitiesWithWhere(){
		
		Query query= em.createNativeQuery("update Activity set description=:descp where id= :id ", Activity.class);
		query.setParameter("descp", "teste native query update");
		query.setParameter("id", 1010);
		
		int noOfrows= query.executeUpdate();
		
		log.info("update activities by Native query for noOfrows  => {} "+noOfrows);		
	
		
	}
	
	
	
	
	
	
	
}
