package com.learning.dao;

import com.learning.Util;
import com.learning.aspects.TransStudent;
import com.learning.aspects.TransactionAspect;
import com.learning.entities.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class StudentDao {

   @TransStudent
   public List<Student> getAllStudents () {
      List<Student> students = new ArrayList<Student>();
      Session session = Util.getConnection().openSession();
      students = session.createQuery("FROM Student", Student.class).getResultList();
      return students;
   }

   @TransStudent
   public void createStudent (Student student) {
      Session session = TransactionAspect.getSession();
      session.persist(student);
   }

   @TransStudent
   public Student getStudentById (Integer studentId) {
      Session session = TransactionAspect.getSession();
      Student student = session.find(Student.class, studentId);
      return student;
   }


   @TransStudent
   public void updateStudent (Student newStudent) {
      Session session = TransactionAspect.getSession();
      session.merge(newStudent);
   }

   @TransStudent
   public void deleteStudent (Integer studentId) {
      Session session = TransactionAspect.getSession();
      Student student = session.find(Student.class, studentId);
      session.remove(student);

   }

   @TransStudent
   //* HQL (hibernate Query Language)
   public List<Student> getStudentByTech (String tech) {
      List<Student> students = new ArrayList<Student>();

      Session session = TransactionAspect.getSession();
      //hql
      String hql = "FROM Student s where s.tech = :tech order by s.name";
      //create query
      Query<Student> query = session.createQuery(hql, Student.class);
      query.setParameter("tech", tech);
      students = query.getResultList();
      return students;
   }

   @TransStudent
   // get Student by age
   public List<Student> getStudentByAge (Integer minAge, Integer maxAge) {
      List<Student> students = new ArrayList<Student>();
      Session session = TransactionAspect.getSession();
      //hql
      String hql = "from Student s where s.age between :min And  :max";
      // create query
      Query<Student> query = session.createQuery(hql, Student.class);
      query.setParameter("min", minAge);
      query.setParameter("max", maxAge);
      students = query.getResultList();
      return students;
   }

}
