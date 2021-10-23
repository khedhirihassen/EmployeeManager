package com.hassen.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassen.Exception.UserNotFoundException;
import com.hassen.model.Employee;
import com.hassen.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee) {
		
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee findEmployeeById(Long id) {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(()-> new UserNotFoundException("User by Id "+id+" was not found"));
				
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteEmployeeById(id);
	}

}
