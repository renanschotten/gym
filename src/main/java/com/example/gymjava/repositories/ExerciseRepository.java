package com.example.gymjava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gymjava.entities.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
	List<Exercise> findByNameIgnoreCase(String name);
}
