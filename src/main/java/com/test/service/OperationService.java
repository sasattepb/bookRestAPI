package com.test.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.BookRepository;
import com.test.model.Book;

@Service
public class OperationService {

	@Autowired
	BookRepository bookRepo;
	
	public Book addBook(Book bookDtls) {
		System.out.println("Add Book!!");
		bookRepo.save(bookDtls);
		
		System.out.println("book count: " +  bookRepo.count());
		Book book = bookRepo.findOne(bookDtls.getBookId());
		System.out.println("Book added: " + book.toString());
		return book;
	}
	
	public Book updateBook(Book bookDtls) {
		System.out.println("Update Book!!");
		bookRepo.update(bookDtls.getTitle(), bookDtls.getBookId());
		
		System.out.println("book count: " +  bookRepo.count());
		Book book = bookRepo.findOne(bookDtls.getBookId());
		System.out.println("Book added: " + book.toString());
		
		return book;
	
	}
		
	public void deleteBook(long delBookId) {

		System.out.println("book count: " +  bookRepo.count());
		bookRepo.delete(delBookId);
		System.out.println("Book deleted : " + delBookId);
		
	}

	public Book searchBook(String searchBookId) {
		System.out.println("book count: " +  bookRepo.count());
		Book book = bookRepo.findOne(Long.parseLong(searchBookId));
		return book;
		//return "book not found!!";
	}

	public String searchBookByTitle(String title) {
		System.out.println("book count: " +  bookRepo.count());
		List<Book> bookList = bookRepo.findByTitle(title);
		String message = "book not found!!";

		for(Book book: bookList){
			System.out.println("Book found: " + book.toString());
			message = book.toString();
		}
		return message;
	}
	
	
	public String findBookbyTitleAndPrice(String title, String price) {
		System.out.println("book count: " +  bookRepo.count());
		List<Book> bookList = bookRepo.findBookbyTitleAndPrice(title, price);
		String message = "book not found!!";

		for(Book book: bookList){
			System.out.println("Book found: " + book.toString());
			message = book.toString();
		}
		return message;
	}

	public List<Book> findAllBooks() {
		System.out.println("Find all Books!!");
		
		List<Book> bookList = (List<Book>) bookRepo.findAll();
		System.out.println("Book size: " + bookList.size());
	
		return bookList;
	}

}
