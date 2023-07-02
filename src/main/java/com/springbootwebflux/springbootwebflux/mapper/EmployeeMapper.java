package com.springbootwebflux.springbootwebflux.mapper;

import com.springbootwebflux.springbootwebflux.dto.EmployeeDto;
import com.springbootwebflux.springbootwebflux.entirty.Employee;

import reactor.core.publisher.Mono;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new  EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
         return new  Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail()
        );
    }
}
