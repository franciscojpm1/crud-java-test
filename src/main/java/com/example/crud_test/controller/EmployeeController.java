package com.example.crud_test.controller;

import com.example.crud_test.model.Employee;
import com.example.crud_test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping("/employee")
    public void saveEmployee(@RequestBody Employee e){
        employeeService.saveEmployee(e);
    }

    @PutMapping("/employee/{id}")
    public void saveEmployee(@PathVariable Long id, @RequestBody Employee e){
        employeeService.updateEmployee(id, e);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
