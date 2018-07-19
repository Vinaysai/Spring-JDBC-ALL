package com.spring.jdbc.bean;

public class Employee {

	private int empid;
	private String name;
	private int age;
	private long salary;

	public int getAge() {
		return age;
	}

	public int getEmpid() {
		return empid;
	}

	public String getName() {
		return name;
	}

	public long getSalary() {
		return salary;
	}

	public void setAge(int i) {
		this.age = i;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
}
