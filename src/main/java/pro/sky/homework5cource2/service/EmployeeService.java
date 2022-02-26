package pro.sky.homework5cource2.service;

import org.springframework.stereotype.Service;
import pro.sky.homework5cource2.Exception.BadRequestException;
import pro.sky.homework5cource2.Exception.InternalServerErrorException;
import pro.sky.homework5cource2.Exception.NotFoundException;


@Service
public class EmployeeService implements IEmployeeManager {

    private boolean has(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        for (Employee employee1 : persArray) {
            if (employee.equals(employee1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Employee addEmployee(String fistName, String lastName) {
        if (has(fistName, lastName)) {
            throw new BadRequestException();
        } else {
            for (int i = 0; i < persArray.length; i++) {
                if (persArray[i] == null) {
                    Employee newEmployee = new Employee(fistName, lastName);
                    persArray[i] = newEmployee;
                    return newEmployee;
                }

            }
        }
        throw new InternalServerErrorException();
    }

    @Override
    public void removeEmployee(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        for (int i = 0; i < persArray.length; i++) {
            if (employee.equals(persArray[i])) {
                persArray[i] = null;
                return;
            }
        }
        throw new NotFoundException();

    }

    @Override
    public Employee findEmployee(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        for (int i = 0; i < persArray.length; i++) {
            if (employee.equals(persArray[i])) {
                return persArray[i];
            }
        }
        throw new NotFoundException();

    }

    private Employee[] persArray = new Employee[]{
            new Employee("Иван", "Сухин"),
            new Employee("Семен", "Семенов"),
            new Employee("Виктор", "Замков"),
            new Employee("Сергей", "Матвеев"),
            new Employee("Маргарита", "Степакова"),
            new Employee("Игнат", "Федотов"),
            new Employee("Марина", "Жукова"),
            new Employee("Станислав", "Сумкин"),
            new Employee("Светлана", "Сумка"),
            new Employee("Андрей", "Петров"),
    };


}
