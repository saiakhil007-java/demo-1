package com.example.demo.repository;

import java.util.ArrayList;

import com.example.demo.model.Employee;

public interface EmployeeRepo {
	ArrayList<Employee> getEmployees();

    Employee getEmployeeById(int employeeId);

    Employee addEmployee(Employee employee);

    Employee updateEmployee(int employeeId, Employee employee);

    void deleteEmployee(int employeeId);


}
