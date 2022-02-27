package pro.sky.homework5cource2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework5cource2.service.Employee;
import pro.sky.homework5cource2.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

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
        employeeService.removeEmployee(fistName, lastName);
        return "Сотрудник " + fistName + " " + lastName + " найден и удален!";
    }


    @GetMapping("/find")
    public String findEmployee(String fistName, String lastName) {
        Employee employee = employeeService.findEmployee(new Employee(fistName, lastName));
        return "Сотрудник " + employee + " найден!";
    }

    @GetMapping("/add")
    public String addEmployee(String fistName, String lastName) {

        Employee newEmployee = employeeService.addEmployee(fistName, lastName);
        return "Сотрудник " + newEmployee + "добавлен книгу учета";
    }

    @GetMapping("/getList")
    public List<String> printList() {
        List<String> result = new ArrayList<String>();
        for (Employee employee : employeeService.getList()) {
            result.add(employee.toString());
        }
        return result;

    }

}


