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


public class MainApplication 
{
	private static Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);
	public static void insertData(Session session)
	{
		//session.beginTransaction();
		Organization organization = new Organization("Test",1,"Test",1,"Test",CompanyType.PRODUCT);
		LOGGER.info(organization.toString());
		session.save(organization);
	}
	public static void getData(Session session,int id)
	{
		Organization organization = session.get(Organization.class, id);
		organization.setSlogan("Test Update");// Update will happen when its done between transaction session
	}
	public static void componentEmbedded(Session session)
	{
		Address address = new Address("Nattar Street","Puducherry",605004);
		Person person = new Person("Naren","7092802533",address);
		session.save(person);
	}
	public static void manyToOneAssociationInsert(Session session)
	{
		Guide guide = new Guide("101","John",20000);
		Student student= new Student("201","Naren",guide);
		Student student1= new Student("202","Sam",guide);
		session.save(student);
		session.save(student1);
		session.save(guide);
	}
	public static void manyToOneAssociationCascadingTest(Session session)
	{
		Student student= session.get(Student.class, 48L);
		LOGGER.info(student.toString());
	}
	public static void oneToOneAssociationInsert(Session session)
	{
		Citizen citizen= new Citizen("Naren","India");
		Passport passport = new Passport("M202110","21102050");
		citizen.setPassport(passport);
		session.persist(citizen);
	}
	public static void oneToManyAssociation(Session session)
	{
		Guide guide = new Guide("101","John",20000);
		Student student= new Student("201","Naren",guide);
		Student student1= new Student("202","Sam",guide);
		guide.addStudent(student);
		guide.addStudent(student1);
		session.persist(guide);
	}
	public static void oneToManyAssociationCascadingTest(Session session)
	{
		Guide guide = session.get(Guide.class, 49L);
		
		Set<Student> stud= guide.getStudentSet();
		LOGGER.info(guide.toString());
		//LOGGER.info(String.valueOf(guide.getStudentSet().size()));// Lazy Fetch happened
		
		//Student student= session.get(Student.class, 47L);
		//guide.setSalary(21000);
		//guide.addStudent(student);
		//session.remove(guide);
		
	}
	public static void manyToManyAssociation(Session session)
	{
		Actor actor = new Actor("Chris Evan",39);
		Actor actor1 = new Actor("Robert Downy",40);
		Actor actor2 = new Actor("Scarlet Johnson",35);
		Movie movie = new Movie("Avenger","5");
		Movie movie1 = new Movie("Iron Man","5");
		movie.getActor().add(actor);
		movie.getActor().add(actor1);
		movie.getActor().add(actor2);
		movie1.getActor().add(actor1);
		session.persist(movie);
		session.persist(movie1);
		
	}
	public static void manyToManyAssociationUpdate(Session session)
	{
		//Actor actor = new Actor("Scarlet Johnson",34);
		Actor actor	= session.get(Actor.class, 4L);
		Movie movie = session.get(Movie.class, 4L);
		//movie.getActor().add(actor);
		actor.addMovie(movie);
	}
	public static void collectionInsert(Session session)
	{
		Friend friend = new Friend("Naren","narendran@gmail.com");
		friend.getNickName().add("John");
		friend.getNickName().add("Sam");
		friend.getNickName().add("George");
		session.persist(friend);
	}
	
	public static void compositeKeys(Session session)
	{
		EmployerPK employerPK= new EmployerPK("INFY1","INFOSYS");
		Employer employer = new Employer(employerPK,"INFOSYS","CHENNAI");
		Employee employee = new Employee("NAREN","narendran3678@gmail.com");
		Employee employee1 = new Employee("SAM","sam3678@gmail.com");
		employer.addEmployee(employee);
		employer.addEmployee(employee1);
		session.persist(employer);
		
	}
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
			//insertData(session);
			//getData(session,111);
			//componentEmbedded(session);
			//manyToOneAssociationInsert(session);
			//manyToOneAssociationCascadingTest(session);
			//oneToManyAssociation(session);
			oneToManyAssociationCascadingTest(session);
			//oneToOneAssociationInsert(session);
			//manyToManyAssociation(session);
			//manyToManyAssociationUpdate(session);
			//collectionInsert(session);
			//compositeKeys(session);
			
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
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-jpa-cnf");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Organization organization = new Organization("TechGroup",1,"600007",1,"Slogan",CompanyType.PRODUCT);
			entityManager.persist(organization);
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
	public static void main(String args[])
	{
		hibernateNativeApi();
		//javaPersistenceAPI();
	}
}
