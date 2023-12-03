package pro.sky.coursespringtree.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.coursespringtree.model.Employee;
import pro.sky.coursespringtree.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllByDepartment(@PathVariable("id") int department) {
        return departmentService.getAllByDepartment(department);
    }


    @GetMapping("/{id}/salary/max")
    public Employee getMaxSalaryByDepartment(@PathVariable("id") int department) {
        return departmentService.getMaxSalaryEmployeesByDepartment(department);
    }

    @GetMapping("/{id}/salary/min")
    public Employee getMinSalaryByDepartment(@PathVariable("id") int department) {
        return departmentService.getMinSalaryEmployeesByDepartment(department);
    }
    @GetMapping("/{id}/salary/sum")
    public Double getSumSalaryEmployeesByDepartment(@PathVariable("id") int department) {
        return departmentService.getSumSalaryEmployeesByDepartment(department);
    }
}
