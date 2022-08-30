package com.example.gymjava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gymjava.entities.MuscleGroup;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {
	List<MuscleGroup> findByNameIgnoreCase(String name);
}
