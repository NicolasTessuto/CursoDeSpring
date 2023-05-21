package com.nts.crudtraining.rest;

import com.nts.crudtraining.entity.Employee;
import com.nts.crudtraining.service.EmployeeService;
import com.nts.crudtraining.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Employee> findById(@PathVariable int employeeId){
        Optional<Employee> theEmployee = employeeService.findById(employeeId);
        if (theEmployee.isEmpty()){
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
    public Optional<Employee> editEmployee(@PathVariable int employeeId, @RequestBody Employee employee){
        Optional<Employee> theEmployee = employeeService.findById(employeeId);
        if(theEmployee.isEmpty()){
            throw new RuntimeException("Employee id not fount - " + employeeId);
        }
        theEmployee.get().setFirst_name(employee.getFirst_name());
        theEmployee.get().setLast_name(employee.getLast_name());
        theEmployee.get().setEmail(employee.getEmail());
        return  theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Optional<Employee> theEmployee = employeeService.findById(employeeId);
        if(theEmployee.isEmpty()){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee [" + theEmployee.get().getId() + "] deleted";
    }

}