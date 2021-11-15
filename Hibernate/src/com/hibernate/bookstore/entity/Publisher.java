package com.hibernate.bookstore.entity;

import java.util.*;
import javax.persistence.*;
@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="publisher_name")
	private String name;
	
	@OneToMany(mappedBy="publisher",cascade= {CascadeType.PERSIST})
	private Set<Book> bookList = new HashSet<Book>();

	public Publisher() {
		super();
	}

	public Publisher(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBookList() {
		return bookList;
	}

	public void setBookList(Set<Book> bookList) {
		this.bookList = bookList;
	}
	public void addBook(Book book)
	{
		book.setPublisher(this);
		bookList.add(book);
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name   + "]";
	}
}
