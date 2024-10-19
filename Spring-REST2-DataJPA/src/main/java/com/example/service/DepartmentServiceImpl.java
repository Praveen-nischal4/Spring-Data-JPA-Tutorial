package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.dao.DepartmentRepository;
import com.example.entity.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository deptRepo;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository myDepRepo)
	{
		this.deptRepo = myDepRepo;
	}
	
	@Override
	public List<Department> finAll() {
		
		return deptRepo.findAll();	
	}

	@Override
	public Optional<Department> findById(int deptid) {
		
		return deptRepo.findById(deptid);
	}

	@Override
	public Department findByID(int deptid) {
	 
		 Optional<Department> mydept = deptRepo.findById(deptid);
		 
		 Department department =null;
		 
		 if(mydept.isPresent())
		 {
			 department =mydept.get();
		 }
		
		return department;
	}

	@Override
	public void deleteDepartment(int deptid) {
		
		deptRepo.deleteById(deptid);
		System.out.println("Record deleted with Id :"+deptid);
	}

	@Override
	public Department saveRecord(Department department) {	
		
		return deptRepo.save(department);
		
	}

	@Override
	public List<Department> getDetailsByAge(int age) {
		
		return deptRepo.getRecordByAge(age);
	}

	
}
