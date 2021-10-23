package com.hassen.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hassen.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public Optional<Employee> findEmployeeById(Long id);
	public void deleteEmployeeById(Long id);

}
