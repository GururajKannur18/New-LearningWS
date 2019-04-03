package com.home.study;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
public class Customer {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long Id;
	public String firstName;
	public String lastName;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
