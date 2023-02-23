package com.spring.service;

import java.util.List;

import com.spring.entity.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	int updateEmployee(Employee employee);

	String deleteById(int id);

}
