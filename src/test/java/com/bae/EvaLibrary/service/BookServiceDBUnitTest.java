package com.bae.EvaLibrary.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.bae.EvaLibrary.data.Book;
import com.bae.EvaLibrary.data.LibraryRepo;

@SpringBootTest
@ActiveProfiles("test")
public class BookServiceDBUnitTest {

	@Autowired
	private BookServiceDB service;

	@MockBean
	private LibraryRepo repo;

	@Test
	void testUpdate() {
		int id = 1;

		Book testBook = new Book(id, "Gravity's Rainbow", "Thomas Pynchon", "Penguin CLassics");
		Book testNewBook = new Book(id, "The Picture of Dorian Gray", "Oscar Wilde", "Vintage Classics");

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testBook));
		Mockito.when(this.repo.save(new Book(id, "The Picture of Dorian Gray", "Oscar Wilde", "Vintage Classics")))
				.thenReturn(testNewBook);

		Book actual = this.service.updateBook(id, testNewBook);

		assertThat(actual).isEqualTo(testNewBook);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1))
				.save(new Book(id, "The Picture of Dorian Gray", "Oscar Wilde", "Vintage Classics"));
	}

	@Test
	void testDeleteSucceeds() {
		int id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.deleteBook(id)).isEqualTo("Borrowed: " + id);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

	@Test
	void testDeleteFails() {
		int id = 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(true);

		assertThat(this.service.deleteBook(id)).isEqualTo("Not Borrowed: " + id);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

	@Test
	void testCreate() {
		Book newBook = new Book("Gravity's Rainbow", "Thomas Pynchon", "Penguin CLassics");

		Book savedBook = new Book(1, "Gravity's Rainbow", "Thomas Pynchon", "Penguin CLassics");

		Mockito.when(this.repo.save(newBook)).thenReturn(savedBook);

		assertThat(this.service.addBook(newBook)).isEqualTo(savedBook);

		Mockito.verify(this.repo, Mockito.times(1)).save(newBook);
	}

}
