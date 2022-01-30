package com.example.homwork7;

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

        employeeMap.put("Новиков Донат", new Employee("Новиков", "Донат"));
        employeeMap.put("Давыдов Виссарион", new Employee("Давыдов", "Виссарион"));
        employeeMap.put("Горбачёв Юрий", new Employee("Горбачёв", "Юрий"));
        employeeMap.put("Попов Ермолай", new Employee("Попов", "Ермолай"));
        employeeMap.put("Зиновьев Станислав", new Employee("Зиновьев", "Станислав"));
        employeeMap.put("Сысоев Наум", new Employee("Сысоев", "Наум"));
        employeeMap.put("Носков Клим", new Employee("Носков", "Клим"));
        employeeMap.put("Белоусов Митрофан", new Employee("Белоусов", "Митрофан"));
        employeeMap.put("Федотов Аверьян", new Employee("Федотов", "Аверьян"));
        employeeMap.put("Селезнёв Василий", new Employee("Селезнёв", "Василий"));

    }

    @Override
    public Employee addEmployee(String lastName, String firstName) {
        if (employeeMap.containsKey(lastName + " " + firstName)) {
            throw new EmployeeAlreadyExistsException();
        } else {
            Employee newEmp = new Employee(lastName, firstName);
            employeeMap.put(lastName + " " + firstName, newEmp);
            return newEmp;
        }
    }

    @Override
    public String deleteEmployee(String lastName, String firstName) {
        if (employeeMap.containsKey(lastName + " " + firstName)) {
            employeeMap.remove(lastName + " " + firstName);
            return lastName + " " + firstName;
        }
        throw new EmployeeIsNotFoundException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        if (employeeMap.containsKey(lastName + " " + firstName)) {
            return employeeMap.get(lastName + " " + firstName);
        }
        throw new EmployeeIsNotFoundException();
    }

    @Override
    public Set<Employee> getEmployee() {
        return new HashSet<>(employeeMap.values());
    }

}