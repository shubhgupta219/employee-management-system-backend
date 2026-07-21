package com.ems.service;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Employee;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public List<Employee> getAllEmployee() {

		List<Employee> data = empRepo.findAll();

		System.out.println(data);

		return data;
	}

	public Employee saveEmployee(Employee emp) {

		if (emp.getAddresses() != null) {
			emp.getAddresses().forEach(address -> address.setEmployee(emp));
		}

		if (emp.getPhoneNumbers() != null) {
			emp.getPhoneNumbers().forEach(phone -> phone.setEmployee(emp));
		}

		return empRepo.save(emp);
	}

	public Employee GetEmployeeById(long id) {

		return empRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
	}

	public void deleteEmp(long id) {

		empRepo.deleteById(id);
	}

	public Employee updateEmployee(long id, Employee updatedEmployee) {

		Employee employee = empRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));

		employee.setEmployeeName(updatedEmployee.getEmployeeName());
		employee.setEmail(updatedEmployee.getEmail());
		employee.setDepartment(updatedEmployee.getDepartment());
		employee.setSalary(updatedEmployee.getSalary());

		employee.getAddresses().clear();

		if (updatedEmployee.getAddresses() != null) {
			updatedEmployee.getAddresses().forEach(address -> {
				address.setEmployee(employee);
				employee.getAddresses().add(address);
			});
		}

		employee.getPhoneNumbers().clear();

		if (updatedEmployee.getPhoneNumbers() != null) {
			updatedEmployee.getPhoneNumbers().forEach(phone -> {
				phone.setEmployee(employee);
				employee.getPhoneNumbers().add(phone);
			});
		}

		return empRepo.save(employee);
	}

	public List<Employee> getEmployeesByDepartment(String dept) {
		
		List<Employee> data = empRepo.findByDepartment(dept);
		
		
//		List<Employee> sortedbyEmpName = data.stream()
//				.sorted(Comparator.comparing(data::getEmployeeName))
//				.collect(Collectors.toList());
		
		
	    return data;
	}

	public List<Employee> getEmpByMobileNumber(String ofcPhone){
		
		return empRepo.findByMobileNumber(ofcPhone);
		
	}
	
	
}