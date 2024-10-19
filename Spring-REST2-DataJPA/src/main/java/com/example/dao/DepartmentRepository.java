package com.example.dao;

import java.util.List;

import com.example.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	@Query("SELECT d from Department d where d.age = :age")
	List<Department> getRecordByAge(@Param("age") int age);
}
