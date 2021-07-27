package com.bae.EvaLibrary.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.EvaLibrary.data.Book;
import com.bae.EvaLibrary.service.BookService;

@RestController
@CrossOrigin

public class LibraryController {

	private BookService service;

	public LibraryController(BookService service) {
		super();
		this.service = service;
	}

	@PostMapping("/addBook")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book created = this.service.createBook(book);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		return this.service.getAllBooks();
	}

	@GetMapping("/getByTitle/{title}")
	public List<Book> getByTitle(@PathVariable String title) {
		return this.service.getByTitle(title);
	}

	@GetMapping("/getByAuthor/{author}")
	public List<Book> getByAuthor(@PathVariable String author) {
		return this.service.getByAuthor(author);
	}

	@GetMapping("/getByPublisher/{publisher}")
	public List<Book> getByPublisher(@PathVariable String publisher) {
		return this.service.getByPublisher(publisher);
	}

	@GetMapping("/getBook/{id}")
	public Book getBook(@PathVariable int id) {
		Book found = this.service.getBook(id);
		return found;
	}

	@PutMapping("/updateBook/{id}")
	public ResponseEntity<Book> replaceBook(@PathVariable int id, @RequestBody Book newBook) {
		Book body = this.service.updateBook(id, newBook);
		return new ResponseEntity<Book>(body, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable int id) {
		String body = this.service.deleteBook(id);
		return new ResponseEntity<String>(body, HttpStatus.NO_CONTENT);
	}

}