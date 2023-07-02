package com.springbootwebflux.springbootwebflux.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String Id;
    private String firstName;
    private String lastName;
    private String email;
}
