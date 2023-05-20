package com.nts.crudtraining.rest;

import com.nts.crudtraining.dao.EmployeeDAO;
import com.nts.crudtraining.entity.Employee;
import com.nts.crudtraining.service.EmployeeService;
import com.nts.crudtraining.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null){
            throw new RuntimeException("Employee Id not fund - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees/")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee theEmployee = employeeService.save(employee);
        return theEmployee;
    }

    @PutMapping("/employees/{employeeId}")
    public Employee editEmployee(@PathVariable int employeeId, @RequestBody Employee employee){
        Employee theEmployee = employeeService.findById(employeeId);
        theEmployee.setFirst_name(employee.getFirst_name());
        theEmployee.setLast_name(employee.getLast_name());
        theEmployee.setEmail(employee.getEmail());
        theEmployee = employeeService.save(theEmployee);
        return  theEmployee;
    }

    @DeleteMapping("/employees/")
    public void deletEmployee(@PathVariable int employeeId){

    }

}