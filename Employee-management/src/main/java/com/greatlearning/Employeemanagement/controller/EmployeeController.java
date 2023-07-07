package com.greatlearning.Employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.Employeemanagement.model.EmployeeModel;
import com.greatlearning.Employeemanagement.service.ServiceEmployee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	ServiceEmployee serviceEmployee;

//	@GetMapping("/list")
//	public List<EmployeeModel> getAllEmployees() {
//		return serviceEmployee.getAllEmployees();
//	}
	
	@PostMapping("/addEmployee")
	public EmployeeModel addEmployee(@RequestParam("employeeId") int id, @RequestParam("firstName") String fName,
			@RequestParam("lastName") String lName, @RequestParam("email") String email) {
		EmployeeModel employee = new EmployeeModel();
		employee.setfName(fName);
		employee.setlName(lName);
		employee.setEmail(email);
		return serviceEmployee.addEmployee(employee);

	}
	
	@DeleteMapping("/deleteEmployee")
	public String deleteEmpployee(@RequestParam("employeeId") int id) {
		serviceEmployee.deleteEmployee(id);
		return "employee details are deleted";
	}
	
	@PutMapping("/updateEmployeeById")
	public EmployeeModel updateEmployeeById(@RequestParam("employeeId") int id,
									@RequestBody EmployeeModel employee){
		return serviceEmployee.updateEmployeeById(id,employee);
	}
	
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		List<EmployeeModel> listEmployee = serviceEmployee.getAllEmployees();
		theModel.addAttribute("employees",listEmployee);
		return "employee/list-employee";
	}
	
	@GetMapping("/new")
	public String showFormForAdd(Model theModel)
	{
		EmployeeModel emp = new EmployeeModel();
		theModel.addAttribute("employees",emp);
		return "employee/employee-form-new";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") EmployeeModel empz)
	{
		serviceEmployee.addEmployee(empz);	
		return "redirect:/employee/list";
	}
	
	@PostMapping("/edit")
	public String showFormForUpdate(@RequestParam("employeeId") int id,
									Model theModel)
	{
		EmployeeModel employeeDb = serviceEmployee.getEmployeeById(id);
		theModel.addAttribute("employee",employeeDb);
		return "employee/employee-form";
	}
	
	@PostMapping("/delete")
	public String deleteMyBook(@RequestParam("employeeId") int id)
	{
		serviceEmployee.deleteEmployee(id);
		return "redirect:/employee/list";
	}
	
}
