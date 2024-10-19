package com.example.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="empid")
	int empid;
	
	@Column(name="ename")
	String name;
	
	@Column(name="email")
	String email;
	
	@Column(name="dept")
	String dept;
	
	public Employee() {
		super();
	}

	public Employee(int empid, String name, String email, String dept) {
		super();
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.dept = dept;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", email=" + email + ", dept=" + dept + "]";
	}
	
	
}
