package com.nicolas.cruddemo.dao;

import com.nicolas.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //Define a field for entity manager
    private EntityManager entityManager;

    //Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
    entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }


}
