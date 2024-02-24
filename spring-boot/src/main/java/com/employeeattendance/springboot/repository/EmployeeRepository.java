package com.employeeattendance.springboot.repository;

import com.employeeattendance.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //crud operations
}
