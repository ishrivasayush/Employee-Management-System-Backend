package com.Narainox.EmployementManagementSystem.repository;

import com.Narainox.EmployementManagementSystem.model.Employee;
import com.Narainox.EmployementManagementSystem.model.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public List<Employee> findByAddress(String address);

    @Query("select new com.Narainox.EmployementManagementSystem.model.EmployeeDTO(e.empName,e.address,e.salary) from Employee e")
    List<EmployeeDTO> getNameAddressSalaryOfAllEmployee();


}
