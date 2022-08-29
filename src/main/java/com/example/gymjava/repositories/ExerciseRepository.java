package com.example.gymjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymjava.entities.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
