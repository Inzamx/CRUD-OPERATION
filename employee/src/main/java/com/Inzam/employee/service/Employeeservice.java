package com.Inzam.employee.service;

import com.Inzam.employee.entity.Employee;
import com.Inzam.employee.repository.Employeerepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Employeeservice {

    private final Employeerepository employeerepository;

    public Employee postEmployee(Employee employee) {
        return employeerepository.save(employee);
    }

    public List<Employee> getAllEmployees(){return employeerepository.findAll();}

    public void deleteEmployee(Long id)
    {
        if(!employeerepository.existsById(id)){
            throw new EntityNotFoundException("Employee with ID " + id + " not found");
        }
        employeerepository.deleteById(id);
    }
    public Employee getEmployeeById(Long id){
        return employeerepository.findById(id).orElse(null);
    }
    public Employee updateEmployee(Long id, Employee employee){
        Optional<Employee> optionalEmployee = employeerepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee existingEmployee = optionalEmployee.get();

            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setName(employee.getName());
            existingEmployee.setPhone(employee.getPhone());
            existingEmployee.setDepartment(employee.getDepartment());

            return employeerepository.save(existingEmployee);
        }
        return null;
    }
}