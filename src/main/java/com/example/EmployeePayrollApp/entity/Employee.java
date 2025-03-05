package com.example.EmployeePayrollApp.entity;

import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
public @Data class Employee {

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


    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> departments;

  public Employee(){}

    public Employee(EmployeeDTO employeeDTO){
      this.updatedEmployee(employeeDTO);
    }

    public void updatedEmployee(EmployeeDTO employeeDTO){
      this.name=employeeDTO.name;
      this.salary=employeeDTO.salary;
      this.gender=employeeDTO.gender;
      this.note=employeeDTO.note;
      this.startDate=employeeDTO.startDate;
      this.profilePic=employeeDTO.profilePic;
      this.departments=employeeDTO.departments;



    }






}