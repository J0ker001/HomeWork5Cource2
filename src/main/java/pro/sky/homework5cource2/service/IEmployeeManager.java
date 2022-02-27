package pro.sky.homework5cource2.service;

import java.util.List;

public interface IEmployeeManager {

    Employee addEmployee(String fistName, String lastName);

    void removeEmployee(String fistName, String lastName);

    Employee findEmployee(Employee employee);

    List<Employee> getList();



}
