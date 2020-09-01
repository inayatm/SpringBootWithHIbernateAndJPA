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
public class JPQLTest {
	
	Logger log=LoggerFactory.getLogger(JPQLTest.class);

	@PersistenceContext
	EntityManager em;
	
	@Test
	public void findAllActivities(){
		
		List<Activity> listactivities= em.createQuery("SELECT a FROM Activity a").getResultList();
		log.info("All activities by JPQL/HQL  => {} "+listactivities);		
	
		
	}
	
	@Test
	public void findAllActivities_typed(){
		
		TypedQuery<Activity> listactivities= em.createQuery("SELECT a FROM Activity a",Activity.class);
		List<Activity> activities=listactivities.getResultList();
		
		log.info("All activities by JPQL/HQL typed  => {} "+activities);		
		
		
	}
	
	
	@Test
	public void findActivityWithWhere() {
		TypedQuery<Activity> query=em.createQuery("SELECT a from Activity a where description like '%running%' ",Activity.class);
		List<Activity> activities=query.getResultList();
		
		log.info("All activities by JPQL/HQL with where condition  => {} "+activities);	
		
	}
	
	@Test
	public void findActivityNamedQuery() {
		
		TypedQuery<Activity> typedactivities=em.createNamedQuery("find_All_Activities", Activity.class);
		
		List<Activity> activities=typedactivities.getResultList();
		
		log.info("All activities by named-queries => {} "+activities);	
		
		
	}
	
	@Test
	public void findActivityNamedQueryWithWhereCondition() {
		
		TypedQuery<Activity> typedactivities=em.createNamedQuery("find_All_ActivitiesWithWhere", Activity.class);
		typedactivities.setParameter("id",1001);
		
		List<Activity> activities=typedactivities.getResultList();
		
		log.info("All activities by named-queries-with where condition:  => {} "+activities);	
		
		
	}
	
	@Test
	public void findActivityNativeQuery() {
		
		Query query=em.createNativeQuery("SELECT * FROM Activity", Activity.class);
		List<Activity> activities=query.getResultList();
		
		log.info("All activities by native query:  => {} "+activities);	
		
		
	}
	
	
	@Test
	@Transactional
	public void updateActivityByNativeQuery() {
		
		Query query=em.createNativeQuery("update Activity set lastupdated_date=sysdate()", Activity.class);
		int noRowsupdated=query.executeUpdate();
		
		log.info("update activities by native query : noRowsupdated => {} "+noRowsupdated);	
		
		
	}
	

	
	
	
	
	
}
