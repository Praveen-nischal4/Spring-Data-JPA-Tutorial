package com.example.conroller;

import java.util.List;
import java.util.Optional;

import com.example.entity.Department;
import com.example.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

	private DepartmentService deptService;
	
	@Autowired
	public DepartmentController(DepartmentService myDeptService)
	{
		this.deptService = myDeptService;
	}
	
	@GetMapping("/listDept")
	public List<Department> getAllDepartment()
	{
		return deptService.finAll();
	}
	
	@GetMapping("/Department/{deptid}")
	public Optional<Department> detailById(@PathVariable int deptid)
	{
		return deptService.findById(deptid);
	}
	
	
	@GetMapping("/Depart/{deptid}")
	public Department departDetailById(@PathVariable int deptid)
	{
		return deptService.findByID(deptid);
	}
	
	@DeleteMapping("/Depart/{deptid}")
	public void deleteRecord(@PathVariable int deptid)
	{
		deptService.deleteDepartment(deptid);
	}
	
	@PostMapping("/addRecord")
	public Department addDepartmentRecord(@RequestBody Department department)
	{
		department.setDeptid(0);  //since we are inserting record and id is auto generated
		Department mydept = deptService.saveRecord(department);
		
		return mydept;
	}
	
	@PutMapping("/updateRecord/{deptid}")
	public Department updateDepartmentRecord(@RequestBody Department department)
	{
		Department myDept = deptService.saveRecord(department);
		return myDept;
	}
	
	//custom query method implementation 
	
	@GetMapping("/custom/{age}")
	public List<Department> getDeatilsByAge(@PathVariable("age") int age)
	{
		return deptService.getDetailsByAge(age);
	}
	
	
	
}
