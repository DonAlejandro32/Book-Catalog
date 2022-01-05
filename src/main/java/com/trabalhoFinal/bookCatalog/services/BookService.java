package com.trabalhoFinal.bookCatalog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhoFinal.bookCatalog.entities.Book;
import com.trabalhoFinal.bookCatalog.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	public List<Book> findAll(){
		return repository.findAll();
	}
	
	public Book findById(Long id) {
		Optional<Book> obj = repository.findById(id);
		return obj.get();
	}
	
	public Book insert(Book obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
	//	try {
			repository.deleteById(id);
	/*	} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}*/
	}
	
	public Book update(Long id, Book obj) {
	//	try {
			@SuppressWarnings("deprecation")
			Book entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
	/*	} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	*/
	} 

	private void updateData(Book entity, Book obj) {
		entity.setName(obj.getName());
		entity.setAuthor(obj.getAuthor());
		entity.setDescription(obj.getDescription());
		entity.setStartReading(obj.getStartReading());
		entity.setEndReading(obj.getEndReading());
	}
	
}
