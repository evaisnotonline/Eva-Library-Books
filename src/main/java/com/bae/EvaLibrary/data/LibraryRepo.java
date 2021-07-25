package com.bae.EvaLibrary.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<Book, Integer> {

	List<Book> findByTitle(String title);

	List<Book> findByAuthor(String author);

	List<Book> findByPublisher(String publisher);

}