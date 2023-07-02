package com.springbootwebflux.springbootwebflux.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootwebflux.springbootwebflux.dto.EmployeeDto;
import com.springbootwebflux.springbootwebflux.entirty.Employee;
import com.springbootwebflux.springbootwebflux.mapper.EmployeeMapper;
import com.springbootwebflux.springbootwebflux.repository.EmployeeRepository;
import com.springbootwebflux.springbootwebflux.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;


     @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employeeMono = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> saveEmployee = employeeRepository.save(employeeMono);
        return saveEmployee.map(
            (employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity)
        );
    }

    @Override
    public Flux<EmployeeDto> getAllEmployy() {
        Flux<Employee> employeeFlux = employeeRepository.findAll();

       return employeeFlux.map(
        (employee) -> EmployeeMapper.mapToEmployeeDto(employee)
       )
       .switchIfEmpty(Flux.empty());
    }

   

  
}
