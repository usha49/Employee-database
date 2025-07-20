package com.usha.controller;

import com.usha.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeResponse> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PostMapping
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest request) {
        return service.addEmployee(request);
    }
    // PUT, DELETE, etc.
}