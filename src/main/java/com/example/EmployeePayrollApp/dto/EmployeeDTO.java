package com.example.EmployeePayrollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
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

  @Pattern(regexp = "male/female",message = "Gender needs to be male or female")
    private String gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "startDate should not be Empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "profilePic cannot be empty")
    private String profilePic;

    @NotNull(message = "department should Not be Empty")
    private List<String> departments;
}