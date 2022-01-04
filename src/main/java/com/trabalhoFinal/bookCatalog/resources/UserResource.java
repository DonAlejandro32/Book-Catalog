package com.trabalhoFinal.bookCatalog.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhoFinal.bookCatalog.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gamil.com", null, "999999999", "123456");
		return ResponseEntity.ok().body(u);	
	}
}
