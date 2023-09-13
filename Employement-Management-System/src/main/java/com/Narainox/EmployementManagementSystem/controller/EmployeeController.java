package com.Narainox.EmployementManagementSystem.controller;

import com.Narainox.EmployementManagementSystem.model.Employee;
import com.Narainox.EmployementManagementSystem.model.EmployeeDTO;
import com.Narainox.EmployementManagementSystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> registerEmployeeHandler(@RequestBody Employee emp)
    {
        Employee employee= employeeService.registerEmployee(emp);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("/employees/{empId}")
    public ResponseEntity<Employee> getEmployeeHandler(@PathVariable Integer empId)
    {
        Employee employee=employeeService.getEmployeeById(empId);
        return new ResponseEntity<>(employee,HttpStatus.FOUND);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployeeHandler()
    {
        List<Employee> employee=employeeService.getAllEmployee();
        return new ResponseEntity<>(employee,HttpStatus.FOUND);
    }

    @DeleteMapping("/employees/{empId}")
    public ResponseEntity<Employee> deleteEmployeeHandler(@PathVariable Integer empId)
    {
        Employee employee=employeeService.deleteEmployeeById(empId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<String> deleteAllEmployeeHandler()
    {
        String s = employeeService.deleteAllEmployee();
        return new ResponseEntity<>(s,HttpStatus.OK);
    }

    @PutMapping("/employees/{empId}")
    public ResponseEntity<Employee> updateEmployeeHandler(@RequestBody Employee employee,@PathVariable Integer empId)
    {
        Employee employee1=employeeService.updateEmployeeDetails(employee,empId);
        return new ResponseEntity<>(employee1,HttpStatus.OK);
    }

    @GetMapping("/employee/{address}")
    public ResponseEntity<List<Employee>> getEmployeesByAddressHandler(@PathVariable String address){
        List<Employee> employees = employeeService.getEmployeeDetailsByAddress(address);
        return new ResponseEntity<>(employees,HttpStatus.FOUND);
    }

    @GetMapping("/employeesdto")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeNameAddressSalary(){
        List<EmployeeDTO> empsDTO = employeeService.getNameAddressSalaryOfAllEmployee();
        return new ResponseEntity<>(empsDTO,HttpStatus.OK);
    }


}
