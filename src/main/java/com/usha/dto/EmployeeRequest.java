package com.usha.dto;

public record EmployeeRequest(String name, String position) {}
public record EmployeeResponse(Long id, String name) {}