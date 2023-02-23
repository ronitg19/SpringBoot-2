package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Employee;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping ("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/allEmp")
	public List<Employee> getAll(){
		return employeeService.getAllEmployee();	
	}
	
	@GetMapping("/{id}")
	public Employee getEmpById(@PathVariable int id){
		Employee employee = employeeService.getEmployeeById(id);
		return employee;	
	}

	@GetMapping("/request")
	public Employee getById(@RequestParam("empcode") int id){
		Employee employee = employeeService.getEmployeeById(id);
		return employee;	
	}
	@PutMapping("/update")
	public String updateEmp(@RequestBody Employee employee) {
		int id = employeeService.updateEmployee(employee);
		return String.format("Employee is updated for id :: {}",id);	
	}
	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		String response = employeeService.deleteById(id);
		return response;
	}

}
