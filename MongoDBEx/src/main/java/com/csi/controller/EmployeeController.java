package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceimpl;

    @PostMapping("/saveData")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeServiceimpl.saveData(employee));
    }

    @GetMapping("/findByID/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeServiceimpl.findByID(empId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeServiceimpl.findAll());
    }

    @PutMapping("/updateData/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId, @RequestBody Employee employee) {
        Employee employee1 = employeeServiceimpl.findByID(empId).orElseThrow(() -> new RecordNotFoundException("EmpId does not Exist !!"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContact(employee.getEmpContact());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());

        return ResponseEntity.ok(employeeServiceimpl.saveData(employee1));
    }

    @DeleteMapping("/deleteById/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId) {
        employeeServiceimpl.deleteById(empId);
        return ResponseEntity.ok("Data Deleted Successfully !!");
    }
}
