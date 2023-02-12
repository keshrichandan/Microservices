package com.springboot.springbootmicroservices.controller;

import com.springboot.springbootmicroservices.model.Employee;
import com.springboot.springbootmicroservices.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Qualifier("employeeServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    private Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @GetMapping("getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }
}
