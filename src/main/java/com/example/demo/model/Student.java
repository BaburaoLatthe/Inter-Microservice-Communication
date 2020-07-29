package com.example.demo.model;

//mark class as an Entity   
//defining class name as Table name  
public class Student {
//mark id as primary key  
//defining id as column name  
	private int id;
//defining name as column name  
	private String name;
//defining age as column name  
	private int age;
//defining email as column name  
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}