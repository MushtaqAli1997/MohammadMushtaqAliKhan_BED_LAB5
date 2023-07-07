package com.greatlearning.Employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.Employeemanagement.model.EmployeeModel;
import com.greatlearning.Employeemanagement.repository.EmployeeRepository;

@Service
public class ServiceEmployee {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<EmployeeModel> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public EmployeeModel addEmployee(EmployeeModel employee) {
		return employeeRepository.save(employee);
		 
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}

	public EmployeeModel updateEmployeeById(int id, EmployeeModel employee) {
		EmployeeModel employeeDb = employeeRepository.findById(id).get();
		employeeDb.setfName(employee.getfName());
		employeeDb.setlName(employee.getlName());
		employeeDb.setEmail(employee.getEmail());
		return employeeRepository.save(employeeDb);
	}

	public EmployeeModel getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}
	
}
