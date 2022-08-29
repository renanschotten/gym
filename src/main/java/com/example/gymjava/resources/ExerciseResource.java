package com.example.gymjava.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.gymjava.entities.Exercise;
import com.example.gymjava.services.ExerciseService;

@RestController
@RequestMapping(value = "/v1/exercises")
public class ExerciseResource {

	@Autowired
	private ExerciseService service;

	@GetMapping
	public ResponseEntity<List<Exercise>> findAll() {
		List<Exercise> exercises = service.findAll();
		return ResponseEntity.ok().body(exercises);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Exercise> findById(@PathVariable Long id) {
		Exercise exercise = service.findById(id);
		return ResponseEntity.ok().body(exercise);
	}

	@PostMapping
	public ResponseEntity<Exercise> insert(@RequestBody Exercise exercise) {
		Exercise ex = service.insert(exercise);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ex.getId()).toUri();
		return ResponseEntity.created(uri).body(ex);
	}

}
