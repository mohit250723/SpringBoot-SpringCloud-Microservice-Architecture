package com.mohit.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.departmentservice.entity.Department;
import com.mohit.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/save")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
	Department departmentSaved=	service.saveDepartment(department);
	return new ResponseEntity<Department>(departmentSaved,HttpStatus.CREATED);
	}
	
	@GetMapping("/find/{departmentId}")
	public ResponseEntity<Department> findDepartment(@PathVariable Long departmentId){
	Department departmentExist=service.getDepartment(departmentId);
	return new ResponseEntity<Department>(departmentExist, HttpStatus.OK);	
	}
	
	@GetMapping("/findall")
	public ResponseEntity<List<Department>> findDepartment(){
	List<Department> departmentList=service.getAllDepartment();
	return new ResponseEntity<List<Department>>(departmentList, HttpStatus.OK);	
	}
	
	

}
