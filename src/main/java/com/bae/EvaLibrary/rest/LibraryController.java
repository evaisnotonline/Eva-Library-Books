package com.bae.EvaLibrary.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.EvaLibrary.data.Book;

@RestController
public class LibraryController {

	private List<Book> Library = new ArrayList<>();

	@PostMapping("/addBook")
	public void addBoook(@RequestBody Book book) {
		System.out.println(book);
		this.Library.add(book);
	}

}