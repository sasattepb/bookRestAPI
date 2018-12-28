package com.test.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="book")
@XmlRootElement
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bookId")
	public long bookId;
	
	@Column(name="title")
	public String title;
	
	@Column(name="price")
	public double price;
	
	@Column(name="volume")
	public int volume; 
	
	@Column(name="publishDate")
	@Temporal(TemporalType.DATE)
	public Date publishDate;	

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}


	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Book(){
		
	}
	public Book(long bookId2, String title2, double price2, int volume2, LocalDate publishdate2) {
		this.bookId = bookId2;
		this.title = title2;
		this.price = price2;
		this.volume = volume2;
		//this.publishDate = publishdate2;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + "]";
	}	
}
