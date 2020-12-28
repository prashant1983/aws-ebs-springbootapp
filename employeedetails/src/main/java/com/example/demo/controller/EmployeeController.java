package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;

	@RequestMapping("/employees/{key}/")
	public ResponseEntity<Employee> getEmploye(@PathVariable(value = "key") String key) {

		Optional<Employee> employee = repository.findById(Long.valueOf(key));

		return ResponseEntity.ok(employee.get());
	}

	@PostMapping(value = "/employees", produces = { "application/json" })
	public ResponseEntity<Employee> createEmploye(@RequestBody Employee employee) {

		System.out.println("===============EmployeeName:" + employee.getName());
		System.out.println("===============EmployeeLastName:" + employee.getLastName());
		System.out.println("===============EmployeeEmail:" + employee.getEmail());
		System.out.println("===============EmployeeId:" + employee.getEmployeeId());
		Employee savedemployee = repository.save(employee);
		return ResponseEntity.ok(savedemployee);
	}
}
