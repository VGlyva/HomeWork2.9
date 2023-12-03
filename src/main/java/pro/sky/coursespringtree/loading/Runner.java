package pro.sky.coursespringtree.loading;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.sky.coursespringtree.service.EmployeeService;

@Component
public class Runner implements CommandLineRunner {
    private final EmployeeService employeeService;

    public Runner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        employeeService.add("Гарри",
                "Поттер", 500, 1);
        employeeService.add("Гермиона",
                "Грейнджер", 600, 1);
        employeeService.add("Малфой",
                "Драко", 700, 2);
        employeeService.add("Грегори",
                "Гоил", 200, 2);
        employeeService.add("Эдди",
                "Мерфи", 900, 3);
        employeeService.add("Джонни",
                "Деп", 800, 3);
    }
}
