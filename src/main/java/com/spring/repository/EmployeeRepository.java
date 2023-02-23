package com.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
