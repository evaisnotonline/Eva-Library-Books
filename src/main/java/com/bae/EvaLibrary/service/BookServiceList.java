package com.bae.EvaLibrary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.EvaLibrary.data.Book;

@Service
public class BookServiceList implements BookService {

	private List<Book> Library = new ArrayList<>();

	@Override
	public Book addBook(Book book) {
		System.out.println(book);
		this.Library.add(book);
		return this.Library.get(this.Library.size() - 1);
	}

	@Override
	public List<Book> getAllBooks() {
		return this.Library;
	}

	@Override
	public Book getBook(int id) {
		Book found = this.Library.get(id);
		return found;
	}

	@Override
	public Book updateBook(int id, Book newBook) {
		return this.Library.set(id, newBook);
	}

	@Override
	public String deleteBook(int id) {
		this.Library.remove(id);
		return "Deleted book with id: " + id;
	}

	@Override
	public List<Book> getByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return null;
	}

}