package com.springboot.springbootmicroservices.service;

import com.springboot.springbootmicroservices.entity.EmployeeEntity;
import com.springboot.springbootmicroservices.model.Employee;
import com.springboot.springbootmicroservices.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty())
        {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity entity= new EmployeeEntity();
        BeanUtils.copyProperties(employee,entity);
        repository.save(entity);
         return employee;
    }
    @Override
    public List<Employee> getAllEmployees() {
       List<EmployeeEntity> employeeEntityList = repository.findAll();
      List<Employee> employees =employeeEntityList.stream()
                .map(employeeEntity -> {
                  Employee employee = new Employee();
                  BeanUtils.copyProperties(employeeEntity,employee);
                  return employee;
                }).collect(Collectors.toList());
        return employees;
    }
    @Override
    public Employee getEmployeeById(String id) {
       EmployeeEntity employeeEntity = repository.findById(id).get();
       Employee employee =new Employee();
       BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }
    @Override
    public String deleteEmployeeById(String id) {
        repository.deleteById(id);
        return "Employee removed from the list with id: "+id;
    }
}
