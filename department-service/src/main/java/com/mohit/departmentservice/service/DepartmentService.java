package com.mohit.departmentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.departmentservice.entity.Department;
import com.mohit.departmentservice.repo.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo repo;
	
	public Department saveDepartment(Department department) {
		repo.save(department);
		return department;
	}
	
	public Department getDepartment(Long deptId) {
		return repo.findById(deptId).get();
		 
	}
	
	public List<Department> getAllDepartment(){
		return repo.findAll();
	}

}
