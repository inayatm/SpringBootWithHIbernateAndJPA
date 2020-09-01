package com.tcs.model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
	
	private BigDecimal hourlyWage;
	
	public PartTimeEmployee() {
		
	}
	
	public PartTimeEmployee(String name,BigDecimal hourlyWage) {
	   	this.name=name;
	   	this.hourlyWage=hourlyWage;
		
	}

	public BigDecimal getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(BigDecimal salary) {
		this.hourlyWage = hourlyWage;
	}
	
	
	
	
	
}