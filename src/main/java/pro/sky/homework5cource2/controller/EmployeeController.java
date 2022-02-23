package pro.sky.homework5cource2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework5cource2.service.EmployeeService;

@RestController
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String wellcome() {
        return "Книга учета сотрудников";

    }


    @GetMapping("/remove")
    public String removeEmployee(String fistName, String lastName) {
        return employeeService.removeEmployee(fistName, lastName);
    }


    @GetMapping("/find")
    public String findEmployee(String fistName, String lastName) {
        return employeeService.findEmployee(fistName, lastName);
    }

    @GetMapping("/add")
    public String addEmployee(String fistName, String lastName) {
        return employeeService.addEmployee(fistName, lastName);
    }


}


