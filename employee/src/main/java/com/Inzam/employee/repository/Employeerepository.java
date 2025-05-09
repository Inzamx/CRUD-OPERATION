package com.Inzam.employee.repository;

import com.Inzam.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepository extends JpaRepository<Employee, Long> {
}
