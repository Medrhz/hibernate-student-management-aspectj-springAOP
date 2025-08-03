package com.learning.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String name;
   private String tech;
   private Integer age;

   public Student (String name, String tech) {
      this.name = name;
      this.tech = tech;
   }
}
