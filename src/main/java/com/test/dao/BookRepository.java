package com.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

	public List<Book> findByTitle(String title);
	
	 @Query("SELECT b FROM Book b WHERE LOWER(b.title) = LOWER(:title) AND LOWER(b.price) = LOWER(:price)")
	 public List<Book> findBookbyTitleAndPrice(@Param("title") String title, @Param("price") String price);

	@Query("Update Book b SET b.title = :title WHERE b.bookId = :bookid")
	@Modifying
	@Transactional
	public void update(@Param("title") String title, @Param("bookid") Long bookid);
}
