package com.mohit.employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.employeeservice.entity.Employee;
import com.mohit.employeeservice.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee employee) {
		repo.save(employee);
		return employee;
	}
	
	public Employee getEmployee(Long empId) {
		return repo.findById(empId).get();
	}

	public List<Employee> getEmployees(){
		return repo.findAll();
	}
	
}
