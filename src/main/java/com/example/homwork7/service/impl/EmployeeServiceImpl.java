package com.example.homwork7.service.impl;

import com.example.homwork7.data.Employee;
import com.example.homwork7.exception.InvalidRequestException;
import com.example.homwork7.exception.EmployeeIsNotFoundException;
import com.example.homwork7.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();

        employeeMap.put("Новиков Донат", new Employee("Новиков", "Донат", 5, 257000));
        employeeMap.put("Давыдов Виссарион", new Employee("Давыдов", "Виссарион", 1, 195000));
        employeeMap.put("Горбачёв Юрий", new Employee("Горбачёв", "Юрий", 4, 460000));
        employeeMap.put("Попов Ермолай", new Employee("Попов", "Ермолай", 3, 473000));
        employeeMap.put("Зиновьев Станислав", new Employee("Зиновьев", "Станислав", 3, 100000));
        employeeMap.put("Сысоев Наум", new Employee("Сысоев", "Наум", 2, 498000));
        employeeMap.put("Носков Клим", new Employee("Носков", "Клим", 3, 392000));
        employeeMap.put("Белоусов Митрофан", new Employee("Белоусов", "Митрофан", 5, 483000));
        employeeMap.put("Федотов Аверьян", new Employee("Федотов", "Аверьян", 1, 275000));
        employeeMap.put("Селезнёв Василий", new Employee("Селезнёв", "Василий", 2, 387000));

    }

    @Override
    public Employee addEmployee(String lastName, String firstName, int department, int salary) {
        if (StringUtils.isAlpha(lastName + firstName)) {
            lastName = StringUtils.capitalize(lastName);
            firstName = StringUtils.capitalize(firstName);
            if (employeeMap.containsKey(lastName + " " + firstName)) {
                throw new InvalidRequestException();
            }
            Employee newEmp = new Employee(lastName, firstName, department, salary);
            employeeMap.put(lastName + " " + firstName, newEmp);
            return newEmp;
        }
        throw new InvalidRequestException();
    }


    @Override
    public String deleteEmployee(String lastName, String firstName) {
        if (StringUtils.isAlpha(lastName + firstName)) {
            lastName = StringUtils.capitalize(lastName);
            firstName = StringUtils.capitalize(firstName);
            if (employeeMap.containsKey(lastName + " " + firstName)) {
                employeeMap.remove(lastName + " " + firstName);
                return lastName + " " + firstName;
            }
            throw new EmployeeIsNotFoundException();
        }
        throw new InvalidRequestException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        if (StringUtils.isAlpha(lastName + firstName)) {
            lastName = StringUtils.capitalize(lastName);
            firstName = StringUtils.capitalize(firstName);
            if (employeeMap.containsKey(lastName + " " + firstName)) {
                return employeeMap.get(lastName + " " + firstName);
            }
            throw new EmployeeIsNotFoundException();
        }
        throw new InvalidRequestException();
    }

    @Override
    public Set<Employee> getEmployee() {
        return new HashSet<>(employeeMap.values());
    }

}