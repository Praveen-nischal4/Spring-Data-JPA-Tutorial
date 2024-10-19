package com.example.dao;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getAllEmployee();
	
	public Employee findRecord(int empid);
	
	public void deleteRecord(int empid);
	
	public Employee update(Employee employee);
}
