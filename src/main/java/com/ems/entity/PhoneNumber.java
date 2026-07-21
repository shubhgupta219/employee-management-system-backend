package com.ems.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "employee_phone_numbers")
@Data
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phoneId;

    private String ofcPhone;
    private String residencePhone;
    private String otherPhone;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	public String getOfcPhone() {
		return ofcPhone;
	}

	public void setOfcPhone(String ofcPhone) {
		this.ofcPhone = ofcPhone;
	}

	public String getResidencePhone() {
		return residencePhone;
	}

	public void setResidencePhone(String residencePhone) {
		this.residencePhone = residencePhone;
	}

	public String getOtherPhone() {
		return otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}	
    
    
	
}
