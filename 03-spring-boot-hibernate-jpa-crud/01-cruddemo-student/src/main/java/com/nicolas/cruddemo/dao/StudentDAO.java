package com.nicolas.cruddemo.dao;

import com.nicolas.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);


}
