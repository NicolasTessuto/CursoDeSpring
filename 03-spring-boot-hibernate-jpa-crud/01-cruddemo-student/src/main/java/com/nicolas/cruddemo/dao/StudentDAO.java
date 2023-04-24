package com.nicolas.cruddemo.dao;

import com.nicolas.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllLastNameOrder();

    List<Student> findByLastName(String theLastName);




}
