package com.Inzam.employee.controller;

import com.Inzam.employee.entity.Employee;
import com.Inzam.employee.service.Employeeservice;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // Fixed incorrect syntax for RequestMapping
@RequiredArgsConstructor
@CrossOrigin("*")
public class Employeecontroller {
    private final Employeeservice employeeservice;

    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee) {
        return employeeservice.postEmployee(employee);}
@GetMapping("/employees")
    public List<Employee> getAllEmployees(){return employeeservice.getAllEmployees();}

@DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){

    try {
        employeeservice.deleteEmployee(id);
        return new ResponseEntity<>("Employee with ID " + id + " deleted successfully", HttpStatus.OK);
    }catch (EntityNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmoloyeeById(@PathVariable Long id){
        Employee employee = employeeservice.getEmployeeById(id);
        if(employee == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employee);


    }
    @PatchMapping("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee updateEmployee = employeeservice.updateEmployee(id, employee);

        if(updateEmployee == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return  ResponseEntity.ok(updateEmployee);
    }
}