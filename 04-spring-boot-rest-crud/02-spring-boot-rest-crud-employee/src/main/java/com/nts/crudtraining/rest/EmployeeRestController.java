package com.nts.crudtraining.rest;

import com.nts.crudtraining.dao.EmployeeDAO;
import com.nts.crudtraining.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    //Constructor injection (dirty method, that will be refactored later)
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

}