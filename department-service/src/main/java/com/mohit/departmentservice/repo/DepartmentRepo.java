package com.mohit.departmentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.departmentservice.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
