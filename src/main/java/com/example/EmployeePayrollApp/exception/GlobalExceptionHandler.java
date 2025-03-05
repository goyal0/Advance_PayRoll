package com.example.EmployeePayrollApp.exception;

import com.example.EmployeePayrollApp.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String MESSAGE = "Exception while processing Rest request";

    //Handle Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        log.error("Validation Error: {}", errors);

        ResponseDTO responseDTO = new ResponseDTO(MESSAGE, errors.toString());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    //Handle Incorrect Date Format Errors
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("Invalid Date Format:", exception);
        ResponseDTO responseDTO = new ResponseDTO(MESSAGE, "Date should be in the format dd-MM-yy");
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    //Handle Employee Not Found Exception
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ResponseDTO> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        log.error("Employee Not Found:", e);
        ResponseDTO responseDTO = new ResponseDTO(MESSAGE, e.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }
}
