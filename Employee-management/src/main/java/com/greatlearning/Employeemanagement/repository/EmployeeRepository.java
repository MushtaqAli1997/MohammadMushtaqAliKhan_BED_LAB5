 package com.greatlearning.Employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.Employeemanagement.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer>{

}
