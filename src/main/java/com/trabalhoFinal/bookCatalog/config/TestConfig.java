package com.trabalhoFinal.bookCatalog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.trabalhoFinal.bookCatalog.entities.Book;
import com.trabalhoFinal.bookCatalog.entities.Genre;
import com.trabalhoFinal.bookCatalog.entities.User;
import com.trabalhoFinal.bookCatalog.repositories.BookRepository;
import com.trabalhoFinal.bookCatalog.repositories.GenreRepository;
import com.trabalhoFinal.bookCatalog.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u = new User(1L, "Maria", "maria@gamil.com", null, "999999999", "123456");
		
		userRepository.save(u);
		
		Book b = new Book(null, "Os Segredos da Mente Milionária", "T. Harv Eker", "Aprenda A Enriquecer Mudando Seus Conceitos Sobre o Dinheiro.", null, null);
		
		bookRepository.save(b);
		
		Genre g = new Genre(null, "AutoAjuda");
		
		genreRepository.save(g);
		
		b.getGenre().add(g);
					
		b.getUsers().add(u);
		
		bookRepository.save(b);
		
		
	}
}
