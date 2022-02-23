package pro.sky.homework5cource2.service;

import org.springframework.stereotype.Service;
import pro.sky.homework5cource2.Exception.BadRequestException;
import pro.sky.homework5cource2.Exception.InternalServerErrorException;
import pro.sky.homework5cource2.Exception.NotFoundException;


@Service
public class EmployeeService implements IEmployee {

    @Override
    public String addEmployee(String fistName, String lastName) {
        Employee newEmployee = new Employee(fistName, lastName);
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i] == null) {
                persArray[i] = newEmployee;
                return "Новый сотрудник, " + newEmployee + " добавлен в базу";
            }
            if (persArray[i].equals(newEmployee)) {
                throw new BadRequestException();
            }
        }
        throw new InternalServerErrorException();
    }

    @Override
    public String removeEmployee(String fistName, String lastName) {
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getFistName().equals(fistName) && persArray[i].getLastName().equals(lastName)) {
                persArray[i] = null;
                return "Сотрудник " + fistName + " " + lastName + " найден и удален!";
            }
        }
        throw new NotFoundException();

    }

    @Override
    public String findEmployee(String fistName, String lastName) {
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getFistName().equals(fistName) && persArray[i].getLastName().equals(lastName)) {
                return "Сотрудник " + persArray[i] + " найден в базе ";
            }
        }
        throw new NotFoundException();

    }

    Employee[] persArray = new Employee[]{
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
