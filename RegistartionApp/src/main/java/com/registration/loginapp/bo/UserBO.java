package com.registration.loginapp.bo;

public class UserBO implements AutoCloseable {

	private int id;
	private String name;
	private String age;
	private String password;
	
	
	public UserBO() {
	}
	


	public UserBO(int id, String name, String age, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.password = password;
	}



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


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "UserBO [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password + "]";
	}



	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
