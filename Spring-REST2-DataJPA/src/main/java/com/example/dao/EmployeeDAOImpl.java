package com.example.dao;

import java.util.List;

import com.example.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired                                                     //constructor injection
	public EmployeeDAOImpl(EntityManager myEntityManager)
	{
		this.entityManager = myEntityManager;
	}

	@Override
	public List<Employee> getAllEmployee() {
	
		TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);
		          List<Employee> myList = query.getResultList();
		
		return myList;
	}

	@Override
	public Employee findRecord(int empid) {
		return  entityManager.find(Employee.class, empid);
		
	}

	@Override
	@Transactional
	public void deleteRecord(int empid) {
		
	 Employee myemp = entityManager.find(Employee.class, empid);
		
	    entityManager.remove(myemp);
	    
	    System.out.println("deleted record with Id :"+empid);
	}

	@Override
	@Transactional
	public Employee update(Employee employee) {
		
		Employee emp = entityManager.merge(employee);
		
		return emp;
	}

}
