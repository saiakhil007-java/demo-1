 package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "employeeid")
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int employeeId;

	@Column(name = "employeename")
	private String employeeName;

	@Column(name = "email")
	private String email;

	@Column(name = "department")
	private String department;

	@Version
	@Column(name = "version")
	private int version;

	public Employee() {
	}

	public Employee(int employeeId, String employeeName, String email, String department) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
