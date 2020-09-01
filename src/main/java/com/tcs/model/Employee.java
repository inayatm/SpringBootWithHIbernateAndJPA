package com.tcs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/*
 * JPA inheritance
 * 
 * */



@Entity
@Inheritance(strategy =InheritanceType.JOINED)    // Separate tables wil be created and joined with foreign key
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //Separate table for each concrete class ..each table will be repeated with common columns
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //Single table will be created but data integrity will effect (columns need to be store null values)
//@DiscriminatorColumn(name = "Employee_Type")  //this is to Rename DType column name when using Single_Table inheritance
//@MappedSuperclass   //It is like SINGLE_TABLE inheritance but if you are using this we need to remove @Entity on this class(mapped super class) and modify the  query while retrieving (SELECT e FROM PartTimeEmployees e)
public class Employee {
	
	@Id
	@GeneratedValue
	public Integer id;
	public String name;

	public Employee(){
		
	}
	
		
	public Employee(String name) {
		this.name = name;
	}

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}




	@Override
	public String toString() {
		return String.format("[Employee:"+this.id+" "+this.name+"]");
	}
	
	
	
	
}
