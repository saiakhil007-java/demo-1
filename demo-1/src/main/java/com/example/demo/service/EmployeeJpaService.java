package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeResponseException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeJpaService implements EmployeeRepo{

    @Autowired
    public EmployeeRepository employeeJpaRepository;

    public ArrayList<Employee> getEmployees() {
        List<Employee> employeeList = employeeJpaRepository.findAll();
        return new ArrayList<>(employeeList);
    }

    public Employee getEmployeeById(int employeeId) {
        try {
            return employeeJpaRepository.findById(employeeId).get();
        } catch (Exception e) {
            throw new EmployeeResponseException("Employee not found with ID: " + employeeId);
        }
    }

    @Transactional
    public Employee addEmployee(Employee employee) {
        employeeJpaRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(int employeeId, Employee employee) {
        try {
            Employee newEmployee = employeeJpaRepository.findById(employeeId).get();

            if (employee.getEmployeeName() != null) {
                newEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if (employee.getEmail() != null) {
                newEmployee.setEmail(employee.getEmail());
            }
            if (employee.getDepartment() != null) {
                newEmployee.setDepartment(employee.getDepartment());
            }

            employeeJpaRepository.save(newEmployee);
            return newEmployee;
        } catch (Exception e) {
            throw new EmployeeResponseException("Cannot update. Employee not found with ID: " + employeeId);
        }
    }

    public void deleteEmployee(int employeeId) {
        try {
            employeeJpaRepository.deleteById(employeeId);
        } catch (Exception e) {
            throw new EmployeeResponseException("Cannot delete. Employee not found with ID: " + employeeId);
        }
    }
}
