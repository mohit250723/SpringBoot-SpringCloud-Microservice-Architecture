package com.mohit.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.employeeservice.entity.Department;
import com.mohit.employeeservice.entity.Employee;
import com.mohit.employeeservice.entity.EmployeeDepartmentVO;
import com.mohit.employeeservice.openFeignClients.DepartmentClient;
import com.mohit.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private DepartmentClient departmentClient;
	
	@PostMapping("/save")
	public ResponseEntity<EmployeeDepartmentVO> saveEmployee(@RequestBody Employee employee){
		Employee empolyeeSaved= service.saveEmployee(employee);
		EmployeeDepartmentVO employeeDepartmentVO= new EmployeeDepartmentVO();
		employeeDepartmentVO.setEmpId(empolyeeSaved.getEmpId());
		employeeDepartmentVO.setEmpName(empolyeeSaved.getEmpName());
		employeeDepartmentVO.setEmpSalary(empolyeeSaved.getEmpSalary());
		// Call the department microservice to get the other details by DepartmentId
		employeeDepartmentVO.setDepartment(getDeptByFeignClient(employee.getDeptId()));
		return new ResponseEntity<EmployeeDepartmentVO>(employeeDepartmentVO,HttpStatus.CREATED);
	}
	
	
	private Department getDeptByFeignClient(Long departmentId) {
		return departmentClient.findDepartment(departmentId).getBody();
		
	}
	
}
