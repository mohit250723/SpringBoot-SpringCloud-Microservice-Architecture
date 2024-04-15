package com.mohit.employeeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.employeeservice.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
