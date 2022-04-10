package com.example.homwork7.controller;

import com.example.homwork7.data.Employee;
import com.example.homwork7.service.impl.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
//@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    //localhost:8080/departments/max-salary?department=1
    @GetMapping("/departments/max-salary")
    public Employee findMaxSalaryInDepartment(@RequestParam int department) {
        return departmentService.employeeWithMaxSalaryDepartment(department);
    }

    //localhost:8080/departments/min-salary?department=1
    @GetMapping("/departments/min-salary")
    public Employee findMinSalaryInDepartment(@RequestParam int department) {
        return departmentService.employeeWithMinSalaryDepartment(department);
    }

    //localhost:8080/departments/all
    @GetMapping("/departments/all")
    public Collection<Employee> findAllEmployeesAndDepartment() {
        return departmentService.allEmployeesAndDepartment();
    }

    //localhost:8080/departments/all?departmentId=5
    @GetMapping("/departments/all")
    public Collection<Employee> findAllEmployeesInDepartment(@RequestParam("departmentId") int department) {
        return departmentService.allEmployeesInDepartment(department);
    }
}
