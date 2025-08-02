package com.learning;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
   public static SessionFactory getConnection () {
      try {
         Configuration configuration = new Configuration();
         configuration.addAnnotatedClass(com.learning.entities.Student.class);
         configuration.configure(); // lit le fichier hibernate.cfg.xml
         SessionFactory sessionFactory = configuration.buildSessionFactory();
         return sessionFactory;
      } catch (HibernateException e) {
         throw new RuntimeException("Erreur lors de la création du SessionFactory", e);
      }

   }
}
