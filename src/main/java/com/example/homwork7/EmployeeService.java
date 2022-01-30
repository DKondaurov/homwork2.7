package com.example.homwork7;

import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName);

    String deleteEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    Set<Employee> getEmployee();
}
