package com.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Book;
import com.test.model.BookDtls;
import com.test.service.OperationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/syllabusapi")
public class CollSyllRestController {
	@Autowired
	OperationService operSvc;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "collage_syllabus";
	}

	@RequestMapping(value = "/addBook", produces = "application/json", consumes = "application/json", method = RequestMethod.POST)
	public Book addBook(@RequestBody Book book) {
		System.out.println("adding book");

		Book book2 = operSvc.addBook(book);
	
		return book2;
	}
	
	@RequestMapping(value = "/updateBook", produces = "application/json", method = RequestMethod.PUT)
	public Book updateBook(@RequestBody Book bookDtls) {
		System.out.println("adding book");

		Book book = operSvc.updateBook(bookDtls);
	
		return book;
	}
	
	
	
	@RequestMapping("/searchBook")
	public Book searchBook(Map<String, Object> model, @RequestParam String bookTitle) {
		System.out.println("adding book");
	
		Book bookDtls = operSvc.searchBook(bookTitle);
		model.put("message", "Book found: " + bookDtls);
		return bookDtls;
	}

	@RequestMapping("/searchBookById")
	public Book searchBookById(Map<String, Object> model, @RequestParam String id) {
		System.out.println("adding book");
	
		Book bookDtls = operSvc.searchBook(id);
		model.put("message", "Book found: " + bookDtls);
		return bookDtls;
	}
	@RequestMapping("/searchBookByTitle")
	public String searchBookByTitle(Map<String, Object> model, @RequestParam String bookTitle) {
		System.out.println("searching book");
	
		String bookDtls = operSvc.searchBookByTitle(bookTitle);
		model.put("message", "Book found: " + bookDtls);
		return "success";
	}
	
	
	@RequestMapping("/searchBookByTitleAndPrice")
	public String findBookbyTitleAndPrice(Map<String, Object> model, @RequestParam String title, @RequestParam String price) {
		System.out.println("searching book");
	
		String bookDtls = operSvc.findBookbyTitleAndPrice(title, price);
		model.put("message", "Book found: " + bookDtls);
		return "success";
	}
	
	@RequestMapping(value = "/deleteBook", produces = "application/json", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBook(@RequestBody Book bookDtls) {
		System.out.println("deleting book");
	
		operSvc.deleteBook(bookDtls.getBookId());
		
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}

	@RequestMapping(value = "/deleteBookById", produces = "application/json", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBook(@RequestParam long bookId) {
		System.out.println("deleting book");
	
		operSvc.deleteBook(bookId);
		
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	@RequestMapping(value = "/allbooks", produces = "application/json", method = RequestMethod.GET)
	public List<Book> deleteBook() {
		System.out.println("get all books");
	
		List<Book> bookList= operSvc.findAllBooks();
		
		return bookList;
		
	}	
}