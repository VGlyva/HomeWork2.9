package pro.sky.coursespringtree.service;

import pro.sky.coursespringtree.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    List<Employee> getAllByDepartment(int department);

    Map<Integer, List<Employee>> getAll();

    Employee getMaxSalaryEmployeesByDepartment(int department);

    Employee getMinSalaryEmployeesByDepartment(int department);

    Double getSumSalaryEmployeesByDepartment(int department);

}


