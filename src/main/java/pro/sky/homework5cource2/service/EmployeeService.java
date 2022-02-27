package pro.sky.homework5cource2.service;

import org.springframework.stereotype.Service;
import pro.sky.homework5cource2.Exception.BadRequestException;
import pro.sky.homework5cource2.Exception.NotFoundException;


import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService implements IEmployeeManager {


    @Override
    public Employee addEmployee(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        if (persArray.contains(employee)) {
            throw new BadRequestException();
        }
        persArray.add(employee);
        return employee;
    }

    @Override
    public void removeEmployee(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        if (!persArray.remove(employee)) {
            throw new NotFoundException();
        }
    }

    @Override
    public Employee findEmployee(Employee employee) {

        if (!persArray.contains(employee)) {
            throw new NotFoundException();
        }
        return persArray.get(persArray.indexOf(employee));
    }

    @Override
    public List<Employee> getList (){
        return persArray;
    }

    private List<Employee> persArray = new  ArrayList<>(List.of(
            new Employee("Иван", "Сухин"),
            new Employee("Семен", "Семенов"),
            new Employee("Виктор", "Замков"),
            new Employee("Сергей", "Матвеев"),
            new Employee("Маргарита", "Степакова"),
            new Employee("Игнат", "Федотов"),
            new Employee("Марина", "Жукова"),
            new Employee("Станислав", "Сумкин"),
            new Employee("Светлана", "Сумка"),
            new Employee("Андрей", "Петров")

    ));


}
