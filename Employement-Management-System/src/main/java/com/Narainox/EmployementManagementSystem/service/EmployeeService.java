package com.Narainox.EmployementManagementSystem.service;

import com.Narainox.EmployementManagementSystem.model.Employee;
import com.Narainox.EmployementManagementSystem.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    Employee registerEmployee(Employee emp);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployee();

    Employee deleteEmployeeById(Integer id);

    String deleteAllEmployee();

    Employee updateEmployeeDetails(Employee employee, Integer empId);

    List<Employee> getEmployeeDetailsByAddress(String address);
    public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee();


}
