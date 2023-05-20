package com.nts.crudtraining.dao;

import com.nts.crudtraining.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}