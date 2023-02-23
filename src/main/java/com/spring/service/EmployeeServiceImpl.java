package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Employee;
import com.spring.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Iterable<Employee> iterable = employeeRepository.findAll();
		return (List<Employee>) iterable;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> response = employeeRepository.findById(id);
		return response.isPresent() ? response.get() : null;
	}

	@Override
	public int updateEmployee(Employee employee) {
		Employee response = employeeRepository.save(employee);
		return response.getId();
	}

	@Override
	public String deleteById(int id) {
		employeeRepository.deleteById(id);
		return "Employee Deleted";	
	}

}
