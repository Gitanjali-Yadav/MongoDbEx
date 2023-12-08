package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//The @Service class typically contains business logic, service methods, and interactions with repositories or other services.
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepo employeeRepoimpl;

    public Employee saveData(Employee employee) {
        return employeeRepoimpl.save(employee);
    }

    public Optional<Employee> findByID(int empId) {
        return employeeRepoimpl.findById(empId);
    }

    public List<Employee> findAll() {
        return employeeRepoimpl.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepoimpl.save(employee);
    }

    public void deleteById(int empId) {
        employeeRepoimpl.deleteById(empId);
    }
}
