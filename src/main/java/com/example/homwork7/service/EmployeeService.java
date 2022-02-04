package com.example.homwork7.service;

import com.example.homwork7.data.Employee;

import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName, int department, int salary);

    String deleteEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    Set<Employee> getEmployee();
}
