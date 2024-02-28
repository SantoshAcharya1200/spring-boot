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

    @PutMapping("{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable long id,@RequestBody Attendance attendanceDetails) {
        Attendance updateAttendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

//        updateAttendance.setEmployee_Id(attendanceDetails.getEmployee_Id());
//        updateAttendance.setAttendance_Date(attendanceDetails.getAttendance_Date());
//        updateAttendance.setAttendance_Status(attendanceDetails.getAttendance_Status());
//        updateAttendance.setAttendance_Time(attendanceDetails.getAttendance_Time());
//        updateAttendance.setAttendance_Date(attendanceDetails.getAttendance_Date());
//        updateAttendance.setAttendance_Date(attendanceDetails.getAttendance_Date());
//        updateAttendance.setEmployee(attendanceDetails.getEmployee());
//        updateAttendance.setAttendanceDate(attendanceDetails.getAttendanceDate());
//        updateAttendance.setAttendanceStatus(attendanceDetails.getAttendanceStatus());
//        updateAttendance.setAttendanceTime(attendanceDetails.getAttendanceTime());

        updateAttendance.setEmployee(attendanceDetails.getEmployee());
        updateAttendance.setAttendance_date(attendanceDetails.getAttendance_date());
        updateAttendance.setAttendance_status(attendanceDetails.getAttendance_status());
        updateAttendance.setAttendance_time(attendanceDetails.getAttendance_time());



        attendanceRepository.save(updateAttendance);



        return ResponseEntity.ok(updateAttendance);
    }


}
