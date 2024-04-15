package com.mohit.employeeservice.openFeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mohit.employeeservice.entity.Department;

@FeignClient(name = "DEPARTMENT-SERVICE",path = "/department-service/api/department")
public interface DepartmentClient{
	
	@GetMapping("/find/{departmentId}")
	public ResponseEntity<Department> findDepartment(@PathVariable Long departmentId);

}
