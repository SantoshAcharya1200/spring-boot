package com.employeeattendance.springboot.controller;

import com.employeeattendance.springboot.exception.ResourceNotFoundException;
import com.employeeattendance.springboot.model.Attendance;
import com.employeeattendance.springboot.model.Employee;
import com.employeeattendance.springboot.repository.AttendanceRepository;
import com.employeeattendance.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
    @PostMapping
    public Attendance createAttendance(@RequestBody Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @GetMapping("{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id:" + id));
        return ResponseEntity.ok(attendance);
    }
}
