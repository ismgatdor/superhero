package com.hero.api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hero.api.to.SuperheroTO;


@RequestMapping(value = "/superhero")
public interface SuperheroController {

	@GetMapping(value = "/findAll", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SuperheroTO>> findAll();
	
	@GetMapping(value = "/findById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SuperheroTO> findById(@PathVariable final Long id);
	
	@GetMapping(value = "/findLike/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SuperheroTO>> findLike(@PathVariable final String name);
	
	@PutMapping(value = "/saveSuperhero", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> saveSuperhero(@RequestBody SuperheroTO bo);
	
	@PutMapping(value = "/updateSuperhero", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateSuperhero(@RequestBody SuperheroTO bo);
	
	
	@DeleteMapping(value = "/deleteSuperhero/{id}")
	public ResponseEntity<Boolean> deleteSuperhero(@PathVariable final Long id);
}
