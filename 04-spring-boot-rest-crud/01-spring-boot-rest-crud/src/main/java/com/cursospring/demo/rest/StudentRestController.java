package com.cursospring.demo.rest;

import com.cursospring.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Nicolas", "Tessuto"));
        theStudents.add(new Student("Victor", "Santos"));
        theStudents.add(new Student("Joao", "Henrique"));
        theStudents.add(new Student("Marcos", "Antonio"));

    }

    @GetMapping("/students-list")
    public List<Student> getAllStudents(){
        return theStudents;
    }
    
}
