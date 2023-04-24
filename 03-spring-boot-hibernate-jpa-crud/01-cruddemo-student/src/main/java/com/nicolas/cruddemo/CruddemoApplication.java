package com.nicolas.cruddemo;

import com.nicolas.cruddemo.dao.StudentDAO;
import com.nicolas.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsOrderByLastName(studentDAO);
			queryForStudentsByLastName(studentDAO);

		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		String theLastName = "Pereira";
		System.out.println(studentDAO.findByLastName(theLastName));
	}

	private void queryForStudentsOrderByLastName(StudentDAO studentDAO) {
		//Get a list of Students Ordered
		List<Student> theStudentsOrdered = studentDAO.findAllLastNameOrder();
		//Display the list
		for(Student tempStudent : theStudentsOrdered){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		// display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}


	}

	private void readStudent(StudentDAO studentDAO){
		System.out.println("Creating a student...");
		Student tempStudent = new Student("Felipe", "Paiva", "FelipePaiva@hotmail.com");
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		System.out.println("Student saved with the ID: " + tempStudent.getId());
		int tempId = tempStudent.getId();
		System.out.println("Printing information of the student: ");
		Student myStudent = studentDAO.findById(tempId);
		System.out.println(myStudent);

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
		Student tempStudent1 = new Student("Joao", "Grillo", "Joao@email.com");
		Student tempStudent2 = new Student("Pedro", "Pereira", "Pedro@email.com");
		Student tempStudent3 = new Student("Thiago", "Oliveira", "Thiago@email.com");

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
