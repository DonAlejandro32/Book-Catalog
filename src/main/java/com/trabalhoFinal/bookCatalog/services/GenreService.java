package com.trabalhoFinal.bookCatalog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoFinal.bookCatalog.entities.Genre;
import com.trabalhoFinal.bookCatalog.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;
	
	public List<Genre> findAll(){
		return repository.findAll();
	}
	
	public Genre findById(Long id) {
		Optional<Genre> obj = repository.findById(id);
		return obj.get();
	}
	
}
