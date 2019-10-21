package com.kefi.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student {
	@Id
	private Integer id;
	private String name;
	private String classeName;
	public Student()
	{}
	public Student(String name, String classeName) {
		this.name=name;
		this.classeName=classeName;
	}
	
	
	
	public Student(Integer id, String name, String classeName) {
		super();
		this.id = id;
		this.name = name;
		this.classeName = classeName;
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
	public String getClasseName() {
		return classeName;
	}
	public void setClasseName(String classeName) {
		this.classeName = classeName;
	}
	
	

}
