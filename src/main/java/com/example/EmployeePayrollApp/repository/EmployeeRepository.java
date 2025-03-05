package com.example.EmployeePayrollApp.repository;

import com.example.EmployeePayrollApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT e.* FROM employees e " +
            "JOIN employee_department ed ON e.id = ed.id " +
            "WHERE ed.department = :department", nativeQuery = true)
    List<Employee> findEmployeeByDepartment(String department);

}
