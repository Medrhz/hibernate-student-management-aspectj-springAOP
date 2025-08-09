package com.learning.services;


import com.learning.dao.StudentDao;
import com.learning.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
   @Autowired
   private StudentDao studentDao;

   public void demoGetAllStudents () {
      for (Student student : studentDao.getAllStudents()) {
         System.out.println("==========================");
         System.out.println(student.getId() + " - " + student.getName() + " -" + student.getTech());
      }
   }

   public void demoCreateStudent (Student student) {
      studentDao.createStudent(student);
   }

   public void demoGetStudentById (Integer studentId) {
      System.out.println(studentDao.getStudentById(studentId));
   }

   public void demoUpdateStudent (Integer studentId, Student newStudent) {
      Student student = studentDao.getStudentById(studentId);
      if (student != null) {
         student.setTech(newStudent.getTech());
         student.setName(newStudent.getName());
         studentDao.updateStudent(student);
      } else {
         System.out.println("Étudiant introuvable avec l'ID : " + studentId);
      }
   }

   public void demoDeleteStudent (Integer studentId) {
      studentDao.deleteStudent(studentId);
   }

   public void demoGetStudentByTech (String tech) {
      for (Student student : studentDao.getStudentByTech(tech)) {
         System.out.println("==========================");
         System.out.println(student.getId() + " - " + student.getName() + " -" + student.getTech());
      }
   }

   public void demoGetStudentByAge (Integer minAge, Integer maxAge) {
      for (Student student : studentDao.getStudentByAge(minAge, maxAge)) {
         System.out.println("==========================");
         System.out.println(student.getId() + " - " + student.getName() + " -" + student.getTech());
      }
   }
}
