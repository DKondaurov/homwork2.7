package com.example.homwork7.constants;

import com.example.homwork7.data.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class EmployeeServiceConstants {
    public static final String LASTNAME = "Фамилия";
    public static final String FIRSTNAME = "Имя";
    public static final String LASTNAME2 = "237";
    public static final int DEPARTMENT = 1;
    public static final int SALARY = 10_000;
    public static final Employee CORRECT_EMPLOYEE = new Employee("Фамилия", "Имя", 1, 10_000);
    public static final Set<Employee> CORRECT_COLLECTION = Set.of(CORRECT_EMPLOYEE);
    public static final List<Employee> EMPLOYEE_LIST = new ArrayList<>(CORRECT_COLLECTION);

}
