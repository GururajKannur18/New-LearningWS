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
	public String FirstName;
	public String LastName;
	
	public Customer(String FirstName, String LastName) {
		this.FirstName = FirstName;
		this.LastName = LastName;
	}
}
