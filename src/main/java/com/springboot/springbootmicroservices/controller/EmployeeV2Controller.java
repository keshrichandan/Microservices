package com.springboot.springbootmicroservices.controller;

import com.springboot.springbootmicroservices.model.Employee;
import com.springboot.springbootmicroservices.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

    @Qualifier("employeeV2ServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    private Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("getEmployee")
    public List<Employee> getAllEmployee(){
       return employeeService.getAllEmployees();
    }

    @GetMapping("/getEmpById/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }
}
