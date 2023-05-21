package com.nts.crudtraining.service;

import com.nts.crudtraining.dao.EmployeeRepository;
import com.nts.crudtraining.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Optional<Employee> findById(int theId) {
        if (employeeRepository.findById(theId).isPresent()){
            return Optional.of(employeeRepository.findById(theId).get());
        }
        else{
            throw new RuntimeException("Didnt find employee id - " + theId);
        }
    }
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
