package com.bae.EvaLibrary.service;

import java.util.List;

import com.bae.EvaLibrary.data.Book;

public interface BookService {

	public Book addBook(Book book);

	public List<Book> getAllBooks();

	public Book getBook(int id);

	public Book updateBook(int id, Book newBook);

	public String deleteBook(int id);

	List<Book> getByTitle(String title);

	List<Book> getByAuthor(String author);

	List<Book> getByPublisher(String publisher);

}