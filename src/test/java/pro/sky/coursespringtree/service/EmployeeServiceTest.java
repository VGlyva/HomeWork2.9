package pro.sky.coursespringtree.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursespringtree.exception.EmployeeAlreadyAddedException;
import pro.sky.coursespringtree.exception.EmployeeNotFoundException;
import pro.sky.coursespringtree.model.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {
    private EmployeeService out;

    private final Employee FIRST_EMPLOYEE = new Employee("Гарри",
            "Поттер", 500, 1);
    private final Employee TWO_EMPLOYEE = new Employee("Драко",
            "Малфой", 500, 1);

    @BeforeEach
    void setOut() {
        out = new EmployeeServiceImpl();
    }

    @Test
    void addCorrectlyEmployees() {
        Employee add = out.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment()
        );
        assertEquals(FIRST_EMPLOYEE, add);
        assertEquals(1, out.findAll().size());

    }

    @Test
    void verificationAlreadyAddedException() {
        out.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment()
        );

        Assertions.assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> out.add(
                        FIRST_EMPLOYEE.getFirstName(),
                        FIRST_EMPLOYEE.getLastName(),
                        FIRST_EMPLOYEE.getSalary(),
                        FIRST_EMPLOYEE.getDepartment())
        );
    }
    @Test
    void verificationNotFoundException() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                ()-> out.remove(
                        TWO_EMPLOYEE.getFirstName(),
                        TWO_EMPLOYEE.getLastName(),
                        TWO_EMPLOYEE.getSalary(),
                        TWO_EMPLOYEE.getDepartment()
                )
        );
    }
    @Test
    void removeCorrectlyEmployees() {
        out.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment()
        );
        assertEquals(1, out.findAll().size());
        out.remove(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment()
        );
        assertEquals(0,out.findAll().size());
    }
    @Test
    void findCorrectlyEmployees () {
        out.add(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment()
        );
        Employee expected = new Employee(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment()
        );
        Employee result = out.find(
                FIRST_EMPLOYEE.getFirstName(),
                FIRST_EMPLOYEE.getLastName(),
                FIRST_EMPLOYEE.getSalary(),
                FIRST_EMPLOYEE.getDepartment()
        );
        assertEquals(expected, result);

    }
}
