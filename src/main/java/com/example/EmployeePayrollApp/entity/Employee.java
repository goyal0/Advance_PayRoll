package com.example.EmployeePayrollApp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public  class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Ensure ID is auto-generated
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)

    private double salary;

    private String gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;









}