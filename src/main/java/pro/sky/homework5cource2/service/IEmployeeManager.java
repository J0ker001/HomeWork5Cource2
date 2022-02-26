package pro.sky.homework5cource2.service;

public interface IEmployeeManager {

    Employee addEmployee(String fistName, String lastName);

    void removeEmployee(String fistName, String lastName);

    Employee findEmployee(String fistName, String lastName);

}
