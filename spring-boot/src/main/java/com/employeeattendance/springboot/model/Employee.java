package com.employeeattendance.springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",nullable = false)
    private String first_name;
    @Column(name = "middle_name")
    private String middle_name;
    @Column(name = "last_name",nullable = false)
    private String last_name;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "age",nullable = false)
    private int age;
    @Column(name = "address")
    private String address;
    @Column(name = "contact_details")
    private String contact_details;


}
