package com.usha.dto;

import com.usha.model.Employee;
import jakarta.validation.constraints.*;

public record EmployeeRequest(
        @NotBlank @Size(max=100) String name,
        @NotBlank String position,
        String address,
        @Pattern(regexp="\\d{10}") String phone,
        @Min(18) int age,
        @Positive long salary
) {
    public Employee toEntity() {
        return new Employee(
                name,        // empName
                address,     // empAddress
                phone,       // empPhone
                position,    // empPost
                age,         // empAge
                salary       // empSalary
        );
        // empId will be auto-generated
    }
}