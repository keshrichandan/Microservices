package com.springboot.springbootmicroservices.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@Table(name="tbl_employee")
public class EmployeeEntity {
    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private String emailId;
}
