package com.learning.aspects;


import com.learning.Util;
import com.learning.dao.StudentDao;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class TransactionAspect {

   private static final ThreadLocal<Session> threadLocalSession = new ThreadLocal<>();
   private static final Logger logger = LoggerFactory.getLogger(StudentDao.class);

   @Around("execution(* com.learning.dao.*.*(..))")
   public Object aroundGetAllStudents (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
      logger.info(" ========================== " + proceedingJoinPoint
          .getSignature()
          .getName() + " operation " + "started ============================= ");
      Transaction transaction = null;
      try (Session session = Util.getConnection().openSession()) {
         threadLocalSession.set(session);
         transaction = session.beginTransaction();
         Object object = proceedingJoinPoint.proceed();
         if (object instanceof java.util.Collection<?> coll && coll.isEmpty()) {
            logger.error("not found any students");
         }
         transaction.commit();
         logger.info(" ========================== " + proceedingJoinPoint
             .getSignature()
             .getName() + " operation" + " done with success =============================");
         return object;
      } catch (Exception e) {

         if (transaction != null) {
            transaction.rollback();
         }
         throw new RuntimeException(e);
      } finally {
         threadLocalSession.remove();
      }
   }

   public static Session getSession () {
      return threadLocalSession.get();
   }

}
