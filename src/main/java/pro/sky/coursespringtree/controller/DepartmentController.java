package pro.sky.coursespringtree.controller;

import pro.sky.coursespringtree.service.DepartmentService;

public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }
}
