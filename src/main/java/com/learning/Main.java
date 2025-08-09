package com.learning;

import com.learning.entities.Student;
import com.learning.services.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.learning"})
public class Main {
   public static void main (String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
      StudentService studentService = context.getBean(StudentService.class);

      System.out.println("----- Demo Create Student -----");
      Student student1 = new Student("student demo", "tech demo");
      studentService.demoCreateStudent(student1);

      System.out.println("----- Demo Get All Students -----");
      studentService.demoGetAllStudents();

//      System.out.println("----- Demo Get Student By ID -----");
//      studentService.demoGetStudentById(student1.getId());  // id بعد persist عادة كيولي مولد

//      System.out.println("----- Demo Update Student -----");
//      Student updatedStudent = new Student("Ahmed Updated", "Spring Boot");
//      studentService.demoUpdateStudent(student1.getId(), updatedStudent);


//      System.out.println("----- Demo Get Updated Student By ID -----");
//      studentService.demoGetStudentById(student1.getId());


//      System.out.println("----- Demo Delete Student -----");
//      studentService.demoDeleteStudent(student1.getId());

//      System.out.println("----- Demo Get All Students After Delete -----");
//      studentService.demoGetAllStudents();


//      System.out.println("----- Demo HQL get student by tech -----");
//      studentService.demoGetStudentByTech("java");


//      System.out.println("----- Demo HQL get student by age -----");
//      studentService.demoGetStudentByAge(20, 30);
   }

}