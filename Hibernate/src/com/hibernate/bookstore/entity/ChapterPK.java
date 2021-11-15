package com.hibernate.bookstore.entity;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class ChapterPK implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long isbn;
	private String chapterNum;
	public ChapterPK(long isbn, String chapterNum) {
		super();
		this.isbn = isbn;
		this.chapterNum = chapterNum;
	}
	public ChapterPK() {
		super();
	}
	
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getChapterNum() {
		return chapterNum;
	}
	public void setChapterNum(String chapterNum) {
		this.chapterNum = chapterNum;
	}
	@Override
	public String toString() {
		return "ChapterPK [isbn=" + isbn + ", chapterNum=" + chapterNum + "]";
	}
	
}
