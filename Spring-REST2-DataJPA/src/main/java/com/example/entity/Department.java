package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dptid")
	private int deptid;
	
	@Column(name="dname")
	private String dname;
	
	@Column(name="dhead")
	private String dhead;
	
	@Column(name="address")
	private String address;
	
	@Column(name="age")
	private int age;
	
	public Department() {
		super();
	}

	public Department(int deptid, String dname, String dhead, String address, int age) {
		super();
		this.deptid = deptid;
		this.dname = dname;
		this.dhead = dhead;
		this.address = address;
		this.age = age;
	}



	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDhead() {
		return dhead;
	}

	public void setDhead(String dhead) {
		this.dhead = dhead;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", dname=" + dname + ", dhead=" + dhead + ", address=" + address
				+ ", age=" + age + "]";
	}
	
	
}
