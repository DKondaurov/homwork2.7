package com.example.homwork7.service.impl;

import com.example.homwork7.data.Employee;
import com.example.homwork7.exception.EmployeeIsNotFoundException;
import com.example.homwork7.exception.InvalidRequestException;
import org.junit.jupiter.api.Test;

import static com.example.homwork7.constants.EmployeeServiceConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void correctAddEmployee() {
        Employee result = out.addEmployee(LASTNAME, FIRSTNAME, DEPARTMENT, SALARY);
        assertEquals(CORRECT_EMPLOYEE, result);
    }

    @Test
    public void addAlreadyExistingEmployee() {
        out.addEmployee(LASTNAME, FIRSTNAME, DEPARTMENT, SALARY);
        assertThrows(InvalidRequestException.class, () -> out.addEmployee(LASTNAME, FIRSTNAME, DEPARTMENT, SALARY));
    }

    @Test
    public void notCorrectAddEmployee() {
        assertThrows(InvalidRequestException.class, () -> out.addEmployee(LASTNAME2, LASTNAME2, DEPARTMENT, SALARY));
    }

    @Test
    public void correctDeleteEmployee() {
        out.addEmployee(LASTNAME, FIRSTNAME, DEPARTMENT, SALARY);
        String result = out.deleteEmployee(LASTNAME, FIRSTNAME);
        assertEquals(result, LASTNAME + " " + FIRSTNAME);
    }

    @Test
    public void deleteNotExistingEmployee() {
        assertThrows(EmployeeIsNotFoundException.class, () -> out.deleteEmployee(LASTNAME, FIRSTNAME));
    }

    @Test
    public void notCorrectDeleteEmployee() {
        assertThrows(InvalidRequestException.class, () -> out.deleteEmployee(LASTNAME2, LASTNAME2));
    }

    @Test
    public void correctFindEmployee() {
        out.addEmployee(LASTNAME, FIRSTNAME, DEPARTMENT, SALARY);
        Employee result = out.findEmployee(LASTNAME, FIRSTNAME);
        assertEquals(result, CORRECT_EMPLOYEE);
    }

    @Test
    public void findNotExistingEmployee() {
        assertThrows(EmployeeIsNotFoundException.class, () -> out.findEmployee(LASTNAME, FIRSTNAME));
    }

    @Test
    public void notCorrectFindEmployee() {
        assertThrows(InvalidRequestException.class, () -> out.findEmployee(LASTNAME2, LASTNAME2));
    }

}