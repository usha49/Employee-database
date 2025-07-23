package com.usha.service;

import com.usha.model.Employee;
import com.usha.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo; // Injected by spring

    // Business logic: Get all employees and apply filters
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    // Business logic: Add employee with validation
    public Employee addEmployee(Employee emp) {
        if (emp.getEmpAge() < 18) {
            throw new IllegalArgumentException("Employee must be 18+ years old.");
        }
        if (repo.existsById(emp.getEmpId())) {
            throw new IllegalArgumentException("Employee ID already exists.");
        }
        if (repo.existsByEmpPhone(emp.getEmpPhone())) {
            throw new IllegalStateException("Phone number already in use");
        }
        return repo.save(emp); //Auto-converted to Insert
    }

    public Employee updateEmployee(int empId, Employee employee) {
        if (!repo.existsById(empId)) {
            throw new IllegalArgumentException("Employee not found.");
        }
        employee.setEmpId(empId);
        return repo.save(employee);
    }

    public void deleteEmployee(int empId){
        repo.deleteById(empId);
    }

    public Employee getEmployeeById(int empId){
        return repo.findById(empId).orElseThrow(()-> new IllegalArgumentException("Employee not found."));
    }

}