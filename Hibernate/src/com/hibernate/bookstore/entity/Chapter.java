package com.hibernate.bookstore.entity;

import javax.persistence.*;

@Entity
public class Chapter 
{
	@EmbeddedId
	private ChapterPK chapterPK;
	
	@Column(name="chapter_name")
	private String name;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="book_isbn")
	@MapsId("isbn")
	private Book book;

	public Chapter() {
		super();
	}

	public Chapter(ChapterPK chapterPK, String name) {
		super();
		this.chapterPK = chapterPK;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Chapter [chapterPK=" + chapterPK + ", name=" + name + "]";
	}
	
	
}
