package com.cursospring.demo.rest;

import com.cursospring.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    @GetMapping("/StudentsList")
    public List<Student> PrintStudents(){
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student("Nicolas", "Tessuto"));
        allStudents.add(new Student("Victor", "Santos"));
        allStudents.add(new Student("Joao", "Henrique"));
        allStudents.add(new Student("Marcos", "Antonio"));
        return allStudents;
    }




}
