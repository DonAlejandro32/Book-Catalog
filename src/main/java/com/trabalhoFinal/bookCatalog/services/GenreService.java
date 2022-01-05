package com.trabalhoFinal.bookCatalog.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.trabalhoFinal.bookCatalog.entities.Genre;
import com.trabalhoFinal.bookCatalog.repositories.GenreRepository;
import com.trabalhoFinal.bookCatalog.services.exceptions.DatabaseException;
import com.trabalhoFinal.bookCatalog.services.exceptions.ResourceNotFoundException;

@Service
public class GenreService {

	@Autowired
	private GenreRepository repository;
	
	public List<Genre> findAll(){
		return repository.findAll();
	}
	
	public Genre findById(Long id) {
		Optional<Genre> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Genre insert(Genre obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Genre update(Long id, Genre obj) {
		try {
			@SuppressWarnings("deprecation")
			Genre entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	} 

	private void updateData(Genre entity, Genre obj) {
		entity.setName(obj.getName());
	}
}
