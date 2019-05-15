package com.arkbackendarkgroup.controller;
import com.arkbackendarkgroup.model.Employee;
import com.arkbackendarkgroup.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	List<Employee> getAllEmployees(){

		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	Employee getEmployee(@PathVariable Long id){
		return employeeService.getEmployeeDetails(id);
	}

	@PostMapping("/save")
	public void addEmployee(@RequestBody Employee employee){

		employeeService.saveEmployee(employee);
	}

	@PutMapping("/update")
	public void updateEmployee(@RequestBody Employee employee){

		employeeService.saveEmployee(employee);
	}

	@DeleteMapping("delete/{id}")
	public void deleteEmployee(@PathVariable Long id){
		 employeeService.deleteEmployeeDetails(id);
	}


}