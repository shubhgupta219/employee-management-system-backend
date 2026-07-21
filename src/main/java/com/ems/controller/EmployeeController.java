package com.ems.controller;

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

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Employee API's", description = "Employee CRUD Operation")
public class EmployeeController {

	@Autowired
	private EmployeeService empsvc;

	@Operation(summary = "Get All Employee")
	@GetMapping("/employee")
	public List<Employee> getEmployee() {

		return empsvc.getAllEmployee();
	}

	@Operation(summary = "Get Employee by passing Id")
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable long id) {

		return empsvc.GetEmployeeById(id);
	}

	@Operation(summary = "Create employe profile")
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee emp) {

		return empsvc.saveEmployee(emp);
	}

	@Operation(summary = "Delete Employee profile")
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable long id) {

		empsvc.deleteEmp(id);
	}

	@Operation(summary = "Update Employee")
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {

		return empsvc.updateEmployee(id, employee);
	}
	
	@GetMapping("/employee/department/{department}")
	public List<Employee> getEmployeesByDepartment(@PathVariable String department) {

	    return empsvc.getEmployeesByDepartment(department);
	}
	@GetMapping("/employee/mobile/{mobno}")
	public List<Employee> getEmployeesByMobNo(@PathVariable String phoneNumbers) {

	    return empsvc.getEmpByMobileNumber(phoneNumbers);
	}
	

}
