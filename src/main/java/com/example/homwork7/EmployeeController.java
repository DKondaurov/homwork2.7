package com.example.homwork7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    private final HelloService helloService;

    public EmployeeController(EmployeeService employeeServiceImpl, HelloService helloServiceImpl) {
        this.employeeService = employeeServiceImpl;
        this.helloService = helloServiceImpl;
    }

    //localhost:8080/employee
    @GetMapping
    public String speakHello() {
        return helloService.speakHello() + " в раздел сотрудники";
    }


    //localhost:8080/employee/add?lastName=Кондауров&firstName=Дмитрий
    @GetMapping("/add")
    public String addEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        return "Сотрудник " + employeeService.addEmployee(lastName, firstName) + " успешно создан.";
    }

    //localhost:8080/employee/remove?lastName=Кондауров&firstName=Дмитрий
    @GetMapping("/remove")
    public String deleteEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        return "Сотрудник " + employeeService.deleteEmployee(lastName, firstName) + " удалён";
    }


    //localhost:8080/employee/find?lastName=Кондауров&firstName=Дмитрий
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }

    //localhost:8080/employee/get
    @GetMapping("/get")
    public Set<Employee> getEmployees() {
        return employeeService.getEmployee();
    }


}