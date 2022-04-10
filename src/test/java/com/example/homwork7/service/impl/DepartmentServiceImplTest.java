package com.example.homwork7.service.impl;

import com.example.homwork7.data.Employee;
import com.example.homwork7.service.DepartmentService;
import com.example.homwork7.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.example.homwork7.constants.EmployeeServiceConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void employeeWithMaxSalaryDepartment() {
        when(employeeService.getEmployee())
                .thenReturn(CORRECT_COLLECTION);
        assertEquals(CORRECT_EMPLOYEE, departmentService.employeeWithMaxSalaryDepartment(1));
    }

    @Test
    public void employeeWithMinSalaryDepartment() {
        when(employeeService.getEmployee())
                .thenReturn(CORRECT_COLLECTION);
        assertEquals(CORRECT_EMPLOYEE, departmentService.employeeWithMinSalaryDepartment(1));
    }

    @Test
    public void allEmployeesInDepartment() {
        when(employeeService.getEmployee())
                .thenReturn(CORRECT_COLLECTION);
        assertEquals(EMPLOYEE_LIST, departmentService.allEmployeesInDepartment(1));
    }

    @Test
    public void allEmployeesAndDepartment() {
        when(employeeService.getEmployee())
                .thenReturn(CORRECT_COLLECTION);
        assertEquals(EMPLOYEE_LIST, departmentService.allEmployeesAndDepartment());
    }
}