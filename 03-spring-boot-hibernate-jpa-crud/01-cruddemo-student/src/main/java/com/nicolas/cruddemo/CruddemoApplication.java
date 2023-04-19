package com.nicolas.cruddemo;

import com.nicolas.cruddemo.dao.StudentDAO;
import com.nicolas.cruddemo.dao.StudentDAOImpl;
import com.nicolas.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);

		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Nícolas", "Santos", "sampleEmail@email.com");
		//Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		//Display the saved student
		System.out.println("Student saved with the ID: [" + tempStudent.getId() + "]" );

	}

	private void createMultipleStudent(StudentDAO studentDAO){
		//Create multipleStudents
		System.out.println("Creating new student object...");
		Student tempStudent1 = new Student("Joao", "Santos", "Joao@email.com");
		Student tempStudent2 = new Student("Pedro", "Santos", "Pedro@email.com");
		Student tempStudent3 = new Student("Thiago", "Santos", "Thiago@email.com");

		//Save the student Objects
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		//Display the saved student
		System.out.println("Student saved with the ID: [" + tempStudent1.getId() + "]" );
		System.out.println("Student saved with the ID: [" + tempStudent2.getId() + "]" );
		System.out.println("Student saved with the ID: [" + tempStudent3.getId() + "]" );
	}
}
