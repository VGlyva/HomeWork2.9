package pro.sky.coursespringtree.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAll() {
        return departmentService.getAll();
    }

    @GetMapping(value = "/all", params = "department")
    public List<Employee> getAllByDepartment(@RequestParam int department) {
        return departmentService.getAllByDepartment(department);
    }


    @GetMapping("/max-salary")
    public Employee getMaxSalaryByDepartment(@RequestParam int department) {
        return departmentService.getMaxSalaryEmployeesByDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryByDepartment(@RequestParam int department) {
        return departmentService.getMinSalaryEmployeesByDepartment(department);
    }
}
