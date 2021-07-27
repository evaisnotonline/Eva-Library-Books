package com.bae.EvaLibrary.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.EvaLibrary.data.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LibraryControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Book testBook = new Book("The Picture of Dorian Gray", "Oscar Wilde", "Vintage Classics");
		String testBookAsJSON = this.mapper.writeValueAsString(testBook);

		System.out.println(testBook);
		System.out.println(testBookAsJSON);

		RequestBuilder request = post("/addBook").contentType(MediaType.APPLICATION_JSON).content(testBookAsJSON);

		ResultMatcher checkStatus = status().is(201);

		Book testCreatedBook = new Book("The Picture of Dorian Gray", "Oscar Wilde", "Vintage Classics");
		testCreatedBook.setId(1);
		String testCreatedBookAsJSON = this.mapper.writeValueAsString(testCreatedBook);

		ResultMatcher checkBody = content().json(testCreatedBookAsJSON);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/deleteBook/1");

		ResultMatcher checkStatus = status().is(200);
		ResultMatcher checkBody = content().string("Deleted: 1");

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		int id = 1;
		Book newBook = new Book("The Picture of Dorian Gray", "Oscar Wilde", "Vintage Classics");
		String newBookAsJSON = this.mapper.writeValueAsString(newBook);

		RequestBuilder req = put("/updateBook/" + id).contentType(MediaType.APPLICATION_JSON).content(newBookAsJSON);

		ResultMatcher checkStatus = status().isAccepted();

		ResultMatcher checkBody = content().json(newBookAsJSON);

		this.mockMVC.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

}