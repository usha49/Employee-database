package com.usha.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmployeeDTO (
    @NotBlank String name, // requires nonempty string
    String address,
    @Size(min = 10, max = 15) String phone, // 10-15 characters
    String position,
    @Min(18) int age,  // Minimum value 18
    long salary)
{

}
