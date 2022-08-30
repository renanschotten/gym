package com.example.gymjava.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.gymjava.entities.MuscleGroup;
import com.example.gymjava.repositories.MuscleGroupRepository;
import com.example.gymjava.services.exception.DatabaseException;
import com.example.gymjava.services.exception.ResourceNotFoundException;

@Service
public class MuscleGroupService {

	@Autowired
	private MuscleGroupRepository repository;

	public List<MuscleGroup> findAll() {
		return repository.findAll();
	}

	public MuscleGroup findById(Long id) {
		Optional<MuscleGroup> exercise = repository.findById(id);
		return exercise.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public MuscleGroup insert(MuscleGroup muscleGroup) {
		return repository.save(muscleGroup);
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

	public MuscleGroup update(Long id, MuscleGroup muscleGroup) {
		try {
			MuscleGroup entity = repository.getReferenceById(id);
			entity.setName(muscleGroup.getName());
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public List<MuscleGroup> findByName(String name) {
		return repository.findByNameIgnoreCase(name);
	}
}
