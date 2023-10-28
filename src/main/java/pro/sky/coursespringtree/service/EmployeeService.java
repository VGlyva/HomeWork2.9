package pro.sky.coursespringtree.service;

import pro.sky.coursespringtree.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int department);
    Employee remove(String firstName, String lastName, int salary, int department);
    Employee find(String firstName, String lastName, int salary, int department);
    Collection<Employee> findAll();
}
