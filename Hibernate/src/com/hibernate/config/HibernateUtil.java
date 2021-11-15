package com.hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory = null;
	private HibernateUtil()
	{
		
	}
	private static SessionFactory buildSessionFactory()
	{
		try
		{
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate-cnf.xml").build();
			Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() 
	{
		if(sessionFactory==null)
		{
			sessionFactory = buildSessionFactory();
		}
        return sessionFactory;
    }

}
