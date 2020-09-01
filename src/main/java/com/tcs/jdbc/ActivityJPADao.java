package com.tcs.jdbc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tcs.model.Activity;

/* Generally you will ude @Trasactional on the code which performs business logic
 * 
 * */


@Repository
@Transactional
public class ActivityJPADao {
	
	//Connection to databse
	@PersistenceContext
	EntityManager entityManager;
	
	Logger log=LoggerFactory.getLogger(ActivityJPADao.class);
	
	
	public Activity findByid(int id) {
		
		return entityManager.find(Activity.class,id);
	}
	
	
	public Activity updateActivity(Activity activity){
		
		return entityManager.merge(activity);
	}
	
	public Activity insertActivity(Activity activity){
		
		return entityManager.merge(activity);
		
		 //entityManager.persist(activity);  //returns void
	}
	
	public void deleteActivityById(int id){
		Activity activity=entityManager.find(Activity.class,id);
		
		entityManager.remove(activity);
		
	}
	
	
	public List<Activity> findAllActvities(){
		
		TypedQuery<Activity> namedquery=entityManager.createNamedQuery("find_All_Activities",Activity.class);
		return namedquery.getResultList();
	}
	
	
	public void playingWithEntityManager() {
		
		Activity activity=new Activity("Descripion for entity","duration for entity");
		
		entityManager.persist(activity);
		
		activity.setDuration("updated duration");
		
		Activity acty=findByid(1001);
		
		acty.setDescription("cardio updated");
		
		
		
	}
	
	
	public void findActivityWithPagination(){
		
		  TypedQuery<Activity> query=entityManager.createQuery("FROM Activity", Activity.class);
		   
		  query.setFirstResult(0);
		  query.setMaxResults(10);
		  
			
		 log.info("findActivityWithPagination recored  size  :  => {} "+query.getResultList().size());
			
			
		}

	
	
	
}
