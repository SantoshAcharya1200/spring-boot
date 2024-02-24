package com.employeeattendance.springboot.repository;

import com.employeeattendance.springboot.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    //crud operations
}
