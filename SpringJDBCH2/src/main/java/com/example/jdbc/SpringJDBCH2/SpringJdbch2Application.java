package com.example.jdbc.SpringJDBCH2;

import com.example.jdbc.SpringJDBCH2.model.Student;
import com.example.jdbc.SpringJDBCH2.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbch2Application {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringJdbch2Application.class, args);
//		System.out.println("started...");

		Student s = context.getBean(Student.class);
		StudentService ser = context.getBean(StudentService.class);

		s.setsNo(104);
		s.setName("priya");
		s.setMarks(90);

		ser.addStudent(s);

		List<Student> students = ser.getStudents();
		System.out.println(students);



	}

}
