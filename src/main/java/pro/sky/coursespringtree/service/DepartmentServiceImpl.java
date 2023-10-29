package pro.sky.coursespringtree.service;

import org.springframework.stereotype.Service;
import pro.sky.coursespringtree.exception.EmployeeNotFoundException;
import pro.sky.coursespringtree.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    public List<Employee> getAllByDepartment(int department) {
        return employeeServiceImpl.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Employee getMaxSalaryEmployeesByDepartment(int department) {
        return employeeServiceImpl.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee getMinSalaryEmployeesByDepartment(int department) {
        return employeeServiceImpl.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Map<Integer, List<Employee>> getAll() {
        return employeeServiceImpl.findAll()
                .stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
