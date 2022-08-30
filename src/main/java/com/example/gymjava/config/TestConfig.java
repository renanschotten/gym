package com.example.gymjava.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.gymjava.entities.Exercise;
import com.example.gymjava.entities.MuscleGroup;
import com.example.gymjava.repositories.ExerciseRepository;
import com.example.gymjava.repositories.MuscleGroupRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Autowired
	private MuscleGroupRepository muscleGroupRepository;

	@Override
	public void run(String... args) throws Exception {
		Exercise ex1 = new Exercise(null, "Leg Press");
		Exercise ex2 = new Exercise(null, "Supino reto");
		Exercise ex3 = new Exercise(null, "Pulley");
		MuscleGroup mg1 = new MuscleGroup(null, "ABS");
		MuscleGroup mg2 = new MuscleGroup(null, "ARMS");
		MuscleGroup mg3 = new MuscleGroup(null, "BACK");
		MuscleGroup mg4 = new MuscleGroup(null, "CHEST");
		MuscleGroup mg5 = new MuscleGroup(null, "LEGS");
		MuscleGroup mg6 = new MuscleGroup(null, "SHOULDERS");
		muscleGroupRepository.saveAll(Arrays.asList(mg1, mg2, mg3, mg4, mg5, mg6));
		ex1.getMuscleGroup().add(mg5);
		ex2.getMuscleGroup().add(mg2);
		ex2.getMuscleGroup().add(mg4);
		ex2.getMuscleGroup().add(mg6);
		ex3.getMuscleGroup().add(mg2);
		ex3.getMuscleGroup().add(mg3);
		ex3.getMuscleGroup().add(mg6);
		exerciseRepository.saveAll(Arrays.asList(ex1, ex2, ex3));
	}

}
