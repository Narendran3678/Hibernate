 package com.hibernate;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hibernate.config.HibernateUtil;

import entity.*;


public class MainApplication1 
{
	private static Logger LOGGER = LoggerFactory.getLogger(MainApplication1.class);
	
	public static void hibernateNativeApi()
	{
		SessionFactory factory 	= null;
		Session session			= null;
		Transaction transacton  = null;
		try
		{
			factory 	= HibernateUtil.getSessionFactory();
			session		= factory.openSession();
			transacton  = session.getTransaction();
			transacton.begin();
			
			
			transacton.commit();	
			//session.getTransaction().commit();
		
		}
		catch(Exception e)
		{
			if(transacton!=null)
				transacton.rollback();
			LOGGER.info(e.toString());
		}
		finally
		{
			if(session!=null)
				session.close();
		}
	}
	
	public static void javaPersistenceAPI()
	{
		
	}
	public static void main(String args[])
	{
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-jpa-cnf");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			//Organization organization = new Organization("TechGroup",1,"600007",1,"Slogan",CompanyType.PRODUCT);
			//entityManager.persist(organization);
			//Student student= entityManager.find(Student.class, 48L);
			//LOGGER.info(student.toString());
			Guide guide = entityManager.getReference(Guide.class, 49L);
			guide.setName("John Cena");
			Set<Student> stud= guide.getStudentSet();
			
			stud.size();
			LOGGER.info(guide.toString());
			

			entityTransaction.commit();
		}
		catch(Exception e)
		{
			if(entityTransaction!=null)
				entityTransaction.rollback();
			LOGGER.info(e.toString());
		}
		finally
		{
			if(entityManager!=null)
				entityManager.close();
		}
	}
}
