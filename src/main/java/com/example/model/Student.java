package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer rollno;
	
	@Column
	private String name;
	
	@Column
	private String city;
	
	public Student() {
		// Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param rollno
	 * @param birthdate
	 */
	public Student(String name, int rollno, String city) {
		this.name = name;
		this.rollno = rollno;
		this.city = city;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rollno
	 */
	public Integer getRollno() {
		return rollno;
	}

	/**
	 * @param rollno the rollno to set
	 */
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	
	
	
	
}
