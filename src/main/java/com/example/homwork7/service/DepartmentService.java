package com.example.homwork7.service;

import com.example.homwork7.data.Employee;

import java.util.Collection;

public interface DepartmentService {

    Employee employeeWithMaxSalaryDepartment(int department);

    Employee employeeWithMinSalaryDepartment(int department);

    Collection<Employee> allEmployeesInDepartment(Integer department);

    Collection<Employee> allEmployeesAndDepartment();

}
