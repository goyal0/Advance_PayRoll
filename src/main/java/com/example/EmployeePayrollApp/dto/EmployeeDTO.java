package com.example.EmployeePayrollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private long id;

    @NotBlank(message = "Name is required and cannot be empty") // Required field
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces") // Only letters & spaces
    private String name;
    @Min(value = 500,message = "min wedge should greater 500")
    private double salary;
    private String gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;
}
