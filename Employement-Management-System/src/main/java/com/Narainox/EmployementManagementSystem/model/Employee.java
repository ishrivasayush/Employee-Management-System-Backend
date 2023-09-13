package com.Narainox.EmployementManagementSystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employess")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer empId;
    @Column(nullable = false)
    private String empName;
    private Integer salary;
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String mobile;
}
