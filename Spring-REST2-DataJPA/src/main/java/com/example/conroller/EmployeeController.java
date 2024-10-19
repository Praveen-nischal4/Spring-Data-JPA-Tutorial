package com.example.conroller;

import java.util.List;

import com.example.dao.EmployeeDAO;
import com.example.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/revision")
public class EmployeeController {

	private EmployeeDAO employeeDAO;
	
   @Autowired                                     //constructor injection
   EmployeeController(EmployeeDAO myEmpDAO)
   {
	   this.employeeDAO = myEmpDAO;
   }
	
	@GetMapping("/welcome")
	public String welcomeGreeting()
	{
		return "Welcome! REST-API World";
	}
	
	@GetMapping("/listEmployee")
	public List<Employee> getList()
	{
		return employeeDAO.getAllEmployee();		
	}
	
	@GetMapping("/Employee/{empid}")
	public Employee empRecord(@PathVariable int empid)
	{
		return employeeDAO.findRecord(empid);
	}
	
	@DeleteMapping("/Employee/{empid}")
	public void delRecord(@PathVariable int empid)
	{
		employeeDAO.deleteRecord(empid);
		System.out.println("Record Deleted with Id :"+empid);
	}
	
	@PutMapping("/Employee/{empid}")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		Employee myEmp = employeeDAO.update(employee);
		return myEmp;
	}
	
}
