package com.trabalhoFinal.bookCatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trabalhoFinal.bookCatalog.entities.Genre;
import com.trabalhoFinal.bookCatalog.services.GenreService;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {
	
	@Autowired
	private GenreService service;
	
	@GetMapping
	public ResponseEntity<List<Genre>> findAll(){
		List<Genre> list = service.findAll(); 
		return ResponseEntity.ok().body(list);	
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Genre> findById(@PathVariable Long id){
		Genre obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Genre> insert(@RequestBody Genre obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Genre> update(@PathVariable Long id, @RequestBody Genre obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
