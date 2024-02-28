package com.employeeattendance.springboot.controller;


import com.employeeattendance.springboot.exception.ResourceNotFoundException;
import com.employeeattendance.springboot.model.Employee;
import com.employeeattendance.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirst_name(employeeDetails.getFirst_name());
        updateEmployee.setMiddle_name(employeeDetails.getMiddle_name());
        updateEmployee.setLast_name(employeeDetails.getLast_name());
        updateEmployee.setGender(employeeDetails.getGender());
        updateEmployee.setAge(employeeDetails.getAge());
        updateEmployee.setAddress(employeeDetails.getAddress());
        updateEmployee.setContact_details(employeeDetails.getContact_details());

        employeeRepository.save(updateEmployee);



        return ResponseEntity.ok(updateEmployee);
    }

}
