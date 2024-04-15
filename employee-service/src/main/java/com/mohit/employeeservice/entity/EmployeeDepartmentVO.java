package com.mohit.employeeservice.entity;

public class EmployeeDepartmentVO {
	
	private Long empId;
	private String empName;
	private String empSalary;
	private Department department;
	
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

}
