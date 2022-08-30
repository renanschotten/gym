package com.example.gymjava.resources;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.gymjava.entities.MuscleGroup;
import com.example.gymjava.services.MuscleGroupService;

@RestController
@RequestMapping(value = "/v1/muscle_groups")
public class MuscleGroupResource {

	@Autowired
	private MuscleGroupService service;

	@GetMapping
	public ResponseEntity<List<MuscleGroup>> findAll() {
		List<MuscleGroup> muscleGroup = service.findAll();
		return ResponseEntity.ok().body(muscleGroup);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MuscleGroup> findById(@PathVariable Long id) {
		MuscleGroup muscleGroup = service.findById(id);
		return ResponseEntity.ok().body(muscleGroup);
	}

	@PostMapping
	public ResponseEntity<MuscleGroup> insert(@RequestBody MuscleGroup muscleGroup) {
		MuscleGroup mg = service.insert(muscleGroup);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mg.getId()).toUri();
		return ResponseEntity.created(uri).body(mg);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MuscleGroup> update(@PathVariable Long id, @RequestBody MuscleGroup muscleGroup) {
		MuscleGroup ex = service.update(id, muscleGroup);
		return ResponseEntity.ok().body(ex);
	}

	@GetMapping(value = "/name")
	public ResponseEntity<List<MuscleGroup>> findByName(@RequestParam String name) {
		return ResponseEntity.ok().body(service.findByName(name));
	}
}
