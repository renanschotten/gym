package com.example.gymjava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gymjava.entities.Exercise;
import com.example.gymjava.repositories.ExerciseRepository;
import com.example.gymjava.services.exception.ResourceNotFoundException;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseRepository repository;

	public List<Exercise> findAll() {
		return repository.findAll();
	}

	public Exercise findById(Long id) {
		Optional<Exercise> exercise = repository.findById(id);
		return exercise.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Exercise insert(Exercise exercise) {
		return repository.save(exercise);
	}
}
