package pro.sky.coursespringtree.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursespringtree.exception.EmployeeNotFoundException;
import pro.sky.coursespringtree.model.Employee;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeServiceImpl;
    @InjectMocks
    private DepartmentServiceImpl out;

    private final Employee MAX_SALARY_EMPLOYEE = new Employee(
            "Максимальный",
            "Макс",
            500,
            1);

    private final Employee MIN_SALARY_EMPLOYEE = new Employee(
            "Минимальный",
            "Мин",
            400,
            1);
    private final List<Employee> EMPLOYEES = List.of(
            MAX_SALARY_EMPLOYEE,
            MIN_SALARY_EMPLOYEE
    );

    @BeforeEach
    void setOut() {
        when(employeeServiceImpl.findAll()).thenReturn(EMPLOYEES);
    }

    @Test
    void correctByDepartment() {
        assertIterableEquals(out.getAllByDepartment(1), EMPLOYEES);

    }

    @Test
    void correctlyAllByDepartment() {
        assertTrue(out.getAll().containsValue(EMPLOYEES));

    }

    @Test
    void correctlyMaxSalary() {
        assertEquals(
                out.getMaxSalaryEmployeesByDepartment(1), MAX_SALARY_EMPLOYEE
        );
        assertThrows(
                EmployeeNotFoundException.class,
                () -> out.getMaxSalaryEmployeesByDepartment(2)
        );
    }

    @Test
    void correctMinSalary() {
        assertEquals(
                out.getMinSalaryEmployeesByDepartment(1), MIN_SALARY_EMPLOYEE
        );
        assertThrows(
                EmployeeNotFoundException.class,
                () -> out.getMinSalaryEmployeesByDepartment(2)
        );
    }

    @Test
    void correctSumSalary() {
        assertEquals(
                900, (double) out.getSumSalaryEmployeesByDepartment(1)
        );
    }
}
