package com.hibernate.bookstore.entity;
import java.util.*;
import javax.persistence.*;
@Entity
public class Book 
{	
	@Id
	private long isbn;
	
	@Column(name="book_name")
	private String bookName;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="publisher_id")
	private Publisher publisher;
	
	@OneToMany(mappedBy="book",cascade= {CascadeType.PERSIST})
	private Set<Chapter> chapter = new HashSet<Chapter>();

	public Book() {
		super();
	}

	public Book(long isbn, String bookName, Publisher publisher) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
		this.publisher = publisher;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Chapter> getChapter() {
		return chapter;
	}

	public void setChapter(Set<Chapter> chapter) {
		this.chapter = chapter;
	}
	public void addChapter(Chapter chapter)
	{
		chapter.setBook(this);
		this.chapter.add(chapter);
	}


	@Override
	public String toString() {
		return "Book [isbn=" + isbn+ ", bookName=" + bookName + ", publisher=" + publisher + ", chapter=" + chapter
				+ "]";
	}
	
	
}
