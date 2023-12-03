package pro.sky.coursespringtree.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.coursespringtree.exception.EmployeeAlreadyAddedException;
import pro.sky.coursespringtree.exception.EmployeeNotFoundException;
import pro.sky.coursespringtree.exception.InvalidInputException;
import pro.sky.coursespringtree.model.Employee;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int department) {
        validateInput(firstName,lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int department) {
        validateInput(firstName,lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int department) {
        validateInput(firstName,lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public  Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private void validateInput(String firstName, String lastName) {
        if (!isAlpha(firstName) && isAlpha(lastName)) {
            throw new InvalidInputException();
        }
    }
}
