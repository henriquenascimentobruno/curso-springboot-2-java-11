package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.User;
import com.educandoweb.curso.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findALL() {	
		//User u = new User(1L, "Maria", "maria@gmail.com", "1733319700", "123456");		
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);		
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

		
}
