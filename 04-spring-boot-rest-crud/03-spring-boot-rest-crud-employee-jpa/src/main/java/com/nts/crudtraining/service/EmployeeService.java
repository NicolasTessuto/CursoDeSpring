package com.nts.crudtraining.service;

import com.nts.crudtraining.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();
    Optional<Employee> findById(int theId);
    Employee save(Employee employee);
    void deleteById(int theId);

}
