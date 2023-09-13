package com.Narainox.EmployementManagementSystem.service.Impl;

import com.Narainox.EmployementManagementSystem.exception.EmployeeException;
import com.Narainox.EmployementManagementSystem.model.Employee;
import com.Narainox.EmployementManagementSystem.model.EmployeeDTO;
import com.Narainox.EmployementManagementSystem.repository.EmployeeRepository;
import com.Narainox.EmployementManagementSystem.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee registerEmployee(Employee emp) {
        Employee employee = employeeRepository.save(emp);
        if (employee!=null)
        {
            return employee;
        }
        else {
            throw new EmployeeException("Invalid Employee Details");
        }

    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        Optional<Employee> employee=employeeRepository.findById(empId);
        if (employee.isPresent())
        {
            return employee.get();
        }
        else {
            throw new EmployeeException("No Employee found with ID: "+ empId);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.size()>0)
        {
            return employees;
        }
        else {
            throw new EmployeeException("No Employee exit. ");
        }
    }

    @Override
    public Employee deleteEmployeeById(Integer empId) {
        Optional<Employee> employee=employeeRepository.findById(empId);
        if (employee.isPresent())
        {
            Employee employee1 = employee.get();
            employeeRepository.deleteById(empId);
            return employee1;
        }
        else {
            throw new EmployeeException("Employee doesn't exist with ID: "+empId);
        }
    }

    @Override
    public String deleteAllEmployee() {
        List<Employee> employee= employeeRepository.findAll();
        if (employee.size()>0)
        {
            employeeRepository.deleteAll();
            return "All Employees Are Deleted";
        }
        else {
            throw new EmployeeException("No Employee exit. ");
        }
    }

    @Override
    public Employee updateEmployeeDetails(Employee employee,Integer empId) {
        Optional<Employee> employee1 = employeeRepository.findById(empId);
        if (employee1.isPresent())
        {
            Employee emp = employee1.get();
            emp.setEmpName(employee.getEmpName());
            emp.setEmail(employee.getEmail());
            emp.setSalary(employee.getSalary());
            emp.setMobile(employee.getMobile());
            emp.setAddress(employee.getAddress());
            employeeRepository.save(employee);
            return emp;
        }
        else {
            throw new EmployeeException("Employee doesn't exist with ID: "+empId);
        }
    }
    @Override
    public List<Employee> getEmployeeDetailsByAddress(String address) {
        List<Employee> employee = employeeRepository.findByAddress(address);
        if (employee.size()>0)
        {
            return employee;
        }
        else {
            throw new EmployeeException("Employees doesn't exist");
        }
    }

    @Override
    public List<EmployeeDTO> getNameAddressSalaryOfAllEmployee(){
        List<EmployeeDTO> employeeDTOList=employeeRepository.getNameAddressSalaryOfAllEmployee();
        if (employeeDTOList.size()>0) {
            return employeeDTOList;
        }
        else {
            throw new EmployeeException("No Employees found: ");
        }
    }




}
