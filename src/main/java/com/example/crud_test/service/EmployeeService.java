package com.example.crud_test.service;

import com.example.crud_test.model.Department;
import com.example.crud_test.model.Employee;
import com.example.crud_test.repository.DepartmentRepository;
import com.example.crud_test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee getEmployee(Long id){
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<Employee> getAllEmployee(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public void saveEmployee(Employee e){
        if(e.getDepartment() != null)
            departmentRepository.save(e.getDepartment());
        employeeRepository.save(e);
    }

    public void updateEmployee(Long id, Employee e){
        if(e.getDepartment() != null)
            departmentRepository.save(e.getDepartment());
        e.setId(id);
        employeeRepository.save(e);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

}
