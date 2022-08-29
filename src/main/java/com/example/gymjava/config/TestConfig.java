package com.example.gymjava.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.gymjava.entities.Exercise;
import com.example.gymjava.repositories.ExerciseRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Override
	public void run(String... args) throws Exception {
		Exercise ex1 = new Exercise(null, "Leg Press");
		Exercise ex2 = new Exercise(null, "Supino reto");
		Exercise ex3 = new Exercise(null, "Pulley");

		exerciseRepository.saveAll(Arrays.asList(ex1, ex2, ex3));

	}

}
