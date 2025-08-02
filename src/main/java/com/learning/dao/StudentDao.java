package com.learning.dao;

import com.learning.Util;
import com.learning.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {


   private static final Logger logger = LoggerFactory.getLogger(StudentDao.class);

   public List<Student> getAllStudents () {
      List<Student> students = new ArrayList<Student>();
      try (Session session = Util.getConnection().openSession()) {
         students = session.createQuery("FROM Student", Student.class).getResultList();

         if (students.isEmpty()) {
//            System.out.println("not found any Students");
            logger.warn("not found any students");
         }
//         System.out.println("get students with success ... ");
         logger.info("get students with success");
         return students;
      } catch (Exception e) {
         logger.error("error to get students");
//         System.out.println("error to get students");
         throw new RuntimeException(e);
      }

   }

   public void createStudent (Student student) {
      Transaction transaction = null;
      try (Session session = Util.getConnection().openSession()) {
         transaction = session.beginTransaction();
         session.persist(student);
         transaction.commit();
         logger.info("add Student with success ... ");
//         System.out.println("add Student with success ... ");
      } catch (Exception e) {
         if (transaction != null) {
            transaction.rollback();
         }
         throw new RuntimeException(e);
      }

   }


   public Student getStudentById (Integer studentId) {
      try (Session session = Util.getConnection().openSession()) {
         Student student = session.find(Student.class, studentId);
         if (student == null) {
            logger.warn("student not found");
//            System.out.println("student not found");
         }
         System.out.println(student);
         return student;

      } catch (Exception e) {
         logger.error("error to get student");
//         System.out.println("error to get student");
         throw new RuntimeException(e);
      }
   }


   public void updateStudent (Student newStudent) {
      Transaction transaction = null;
      try (Session session = Util.getConnection().openSession()) {
         transaction = session.beginTransaction();
         session.merge(newStudent);
         transaction.commit();
         logger.info("update Student with success ... ");
//         System.out.println("update Student with success ... ");
      } catch (Exception e) {
         if (transaction != null) {
            transaction.rollback();
         }
         throw new RuntimeException(e);
      }
   }

   public void deleteStudent (Integer studentId) {
      Transaction transaction = null;
      try (Session session = Util.getConnection().openSession()) {
         transaction = session.beginTransaction();

         Student student = session.find(Student.class, studentId);
         if (student == null) {
            logger.warn("Student not found!");
//            System.out.println("Student not found!");
            return; // 🔒 On arrête ici si l'étudiant n'existe pas
         }

         session.remove(student);
         transaction.commit();
         logger.info("Delete student with success...");
//         System.out.println("Delete student with success...");
      } catch (Exception e) {
         if (transaction != null) {
            transaction.rollback();
         }
         throw new RuntimeException(e);
      }
   }


   //! demonstration

   public void demoGetAllStudents () {
      for (Student student : getAllStudents()) {
         System.out.println("==========================");
         System.out.println(student.getId() + " - " + student.getName() + " -" + student.getTech());
      }
   }

   public void demoCreateStudent (Student student) {
      createStudent(student);
   }

   public void demoGetStudentById (Integer studentId) {
      System.out.println(getStudentById(studentId));
   }

   public void demoUpdateStudent (Integer studentId, Student newStudent) {
      Student student = getStudentById(studentId);
      if (student != null) {
         student.setTech(newStudent.getTech());
         student.setName(newStudent.getName());
         updateStudent(student);
      } else {
         System.out.println("Étudiant introuvable avec l'ID : " + studentId);
      }
   }

   public void demoDeleteStudent (Integer studentId) {
      deleteStudent(studentId);
   }

}
