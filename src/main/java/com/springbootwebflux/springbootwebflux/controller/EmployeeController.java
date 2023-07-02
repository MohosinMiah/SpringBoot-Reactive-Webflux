package com.springbootwebflux.springbootwebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootwebflux.springbootwebflux.dto.EmployeeDto;
import com.springbootwebflux.springbootwebflux.entirty.Employee;
import com.springbootwebflux.springbootwebflux.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


  @Autowired
  EmployeeService employeeService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Flux<EmployeeDto> getAllEmployee() {

      return employeeService.getAllEmployy();

  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
    return employeeService.saveEmployee(employeeDto);
  }


    @GetMapping("/{Id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> getEmployeeById(@PathVariable("Id") String Id) {
        return employeeService.getEmployeeById(Id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<EmployeeDto> updateEmployee(@PathVariable("id") String id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable("id") String id) {
        return employeeService.deleteEmployeeById(id);
    }

}
