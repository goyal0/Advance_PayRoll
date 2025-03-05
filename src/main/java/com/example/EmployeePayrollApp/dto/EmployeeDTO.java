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

    @NotBlank(message = "Name is required and cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces")
    public String name;

    @Min(value = 500, message = "Minimum wage should be greater than 500")
    public double salary;

    @Pattern(regexp = "(male|female)", message = "Gender must be either 'male' or 'female'")
    public String gender;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "Start date should not be empty")
    @PastOrPresent(message = "Start date should be a past or today's date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    public String note;

    @NotBlank(message = "Profile picture cannot be empty")
    public String profilePic;

    @NotNull(message = "Departments should not be empty")
    public List<String> departments;
}
