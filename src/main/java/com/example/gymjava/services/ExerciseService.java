package com.example.gymjava.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.gymjava.entities.Exercise;
import com.example.gymjava.repositories.ExerciseRepository;
import com.example.gymjava.services.exception.DatabaseException;
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

	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Exercise update(Long id, Exercise exercise) {
		try {
			Exercise entity = repository.getReferenceById(id);
			entity.setName(exercise.getName());
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public List<Exercise> findByName(String name) {
		return repository.findByNameIgnoreCase(name);
	}

}
