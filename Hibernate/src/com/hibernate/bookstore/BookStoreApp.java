package com.hibernate.bookstore;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hibernate.bookstore.entity.*;
import com.hibernate.config.HibernateUtil;

public class BookStoreApp 
{
	
	private static Logger LOGGER = LoggerFactory.getLogger(BookStoreApp.class);
	
	public static void insertBook(Session session)
	{
		Publisher publisher = new Publisher("User1");
		Book book = new Book(2021,"Hibernate",publisher);
		
		ChapterPK chapterPk = new ChapterPK(book.getIsbn(),"1");
		Chapter chapter = new Chapter(chapterPk,"Basics");
		ChapterPK chapterPk1 = new ChapterPK(book.getIsbn(),"2");
		Chapter chapter1 = new Chapter(chapterPk1,"Fundamentals");
		
		//book.addChapter(chapter);
		//book.addChapter(chapter1);
		//session.persist(book);
	}
	public static void getBook(Session session)
	{
		Book book = session.get(Book.class, 2021L);
		Publisher publisher = book.getPublisher();
		Set<Book> bookList = publisher.getBookList();
		LOGGER.info("###Publisher### - "+publisher.toString());
		Iterator iterator = bookList.iterator();
		while(iterator.hasNext())
		{
			Book bok= (Book) iterator.next();
			LOGGER.info(bok.toString());
		}
//		LOGGER.info("###BookList### - "+String.valueOf(bookList.toString()));
	}
	public static void main(String[] args) 
	{
		SessionFactory factory 	= null;
		Session session			= null;
		Transaction transacton  = null;
		try
		{
			factory 	= HibernateUtil.getSessionFactory();
			session		= factory.openSession();
			//transacton  = session.getTransaction();
			//transacton.begin();
			//insertBook(session);
			session.beginTransaction();
			getBook(session);
			//transacton.commit();
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
}
