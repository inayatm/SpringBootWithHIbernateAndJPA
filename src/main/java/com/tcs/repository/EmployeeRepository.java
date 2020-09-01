package com.tcs.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tcs.model.Employee;

@Repository
@Transactional
public class EmployeeRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public void insertEmployee(Employee employee) {
	 
	 em.persist(employee);
	 
	 	
	}
	
	public List<Employee> getAllEmployees() {
		
		Query createQuery=em.createQuery("SELECT E FROM Employee E");
		
		return createQuery.getResultList();
		
		
		
		
	}

	
	
}
