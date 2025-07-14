package com.usha.service;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import com.usha.model.Employee;
import com.usha.repository.EmployeeRepository;

public class EmployeeService {
    private final Connection conn;

    public EmployeeService(Connection conn) {
        this.conn = conn;
    }

    // Business logic: Get all employees and apply filters
    public ArrayList<Employee> getAllEmployees() throws SQLException {
        return EmployeeRepository.getAllEmployees(conn);
    }

    // Business logic: Add employee with validation
    public void addEmployee(Employee emp) throws SQLException {
        if (emp.getEmpAge() < 18) {
            throw new IllegalArgumentException("Employee must be 18+ years old.");
        }
        if (doesEmployeeExist(emp.getEmpId())) {
            throw new IllegalArgumentException("Employee ID already exists.");
        }
        EmployeeRepository.addEmployee(conn, emp);
    }

    public void updateEmployee(int empId, Map<String, Object> updates) throws SQLException {
        if (updates == null || updates.isEmpty()) {
            throw new IllegalArgumentException("No updates provided.");
        }
        EmployeeRepository.updateEmployee(conn, empId, updates);
    }

    public void deleteEmployee(int empId) throws SQLException {
        EmployeeRepository.deleteEmployee(conn,empId);
    }

    public boolean doesEmployeeExist(int empId) throws SQLException {
        return EmployeeRepository.existsById(conn, empId);
    }

    public Employee getEmployeeById(int empId) throws SQLException {
        return EmployeeRepository.getEmployeeById(conn, empId);
    }
}