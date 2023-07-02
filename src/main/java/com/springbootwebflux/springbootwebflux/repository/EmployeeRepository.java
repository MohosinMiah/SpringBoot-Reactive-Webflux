package com.springbootwebflux.springbootwebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.springbootwebflux.springbootwebflux.entirty.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String>{
    
}
