package com.learning;

import com.learning.dao.StudentDao;
import com.learning.entities.Student;

public class Main {


   public static void main (String[] args) {

      StudentDao dao = new StudentDao();

      System.out.println("----- Demo Create Student -----");
      Student student1 = new Student("Ahmed", "Java");
      dao.demoCreateStudent(student1);

//      System.out.println("----- Demo Get All Students -----");
//      dao.demoGetAllStudents();
//
//      System.out.println("----- Demo Get Student By ID -----");
//      dao.demoGetStudentById(student1.getId());  // id بعد persist عادة كيولي مولد
//
//      System.out.println("----- Demo Update Student -----");
//      Student updatedStudent = new Student("Ahmed Updated", "Spring Boot");
//      dao.demoUpdateStudent(student1.getId(), updatedStudent);
//
//      System.out.println("----- Demo Get Updated Student By ID -----");
//      dao.demoGetStudentById(student1.getId());
//
//      System.out.println("----- Demo Delete Student -----");
//      dao.demoDeleteStudent(student1.getId());
//
//      System.out.println("----- Demo Get All Students After Delete -----");
//      dao.demoGetAllStudents();
   }

}