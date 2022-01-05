package com.trabalhoFinal.bookCatalog.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		User u1 = new User(null, "Maria", "maria@gamil.com", sdf.parse("04/07/1984"), "999999999", "123456");
		User u2 = new User(null, "Bob", "bob@gamil.com", sdf.parse("04/02/1984"), "999999999", "123456");
		User u3 = new User(null, "Carlos", "carlos@gamil.com", sdf.parse("04/05/1984"), "999999999", "123456");
		User u4 = new User(null, "Marcos", "marcos@gamil.com", sdf.parse("04/010/1984"), "999999999", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
		Book b = new Book(null, "Os Segredos da Mente Milionária", "T. Harv Eker", "Aprenda A Enriquecer Mudando Seus Conceitos Sobre o Dinheiro.", sdf.parse("19/10/2015"), sdf.parse("25/12/2015"));
		
		bookRepository.save(b);
		
		Genre g = new Genre(null, "AutoAjuda");
		
		genreRepository.save(g);
		
		b.getGenre().add(g);
					
		b.getUsers().add(u1);
		b.getUsers().add(u2);
		b.getUsers().add(u3);
		b.getUsers().add(u4);
		
		bookRepository.save(b);
		
		
	}
}
