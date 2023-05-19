package com.nts.crudtraining.dao;

import com.nts.crudtraining.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
