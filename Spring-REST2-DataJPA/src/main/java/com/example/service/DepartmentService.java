package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Department;

public interface DepartmentService {

	public List<Department> finAll();
	
	public Optional<Department> findById(int deptid);
	
	public Department findByID(int deptid);
	
	public void deleteDepartment(int deptid);
	
	public Department saveRecord(Department department);
	
	public List<Department> getDetailsByAge(int age);
}
