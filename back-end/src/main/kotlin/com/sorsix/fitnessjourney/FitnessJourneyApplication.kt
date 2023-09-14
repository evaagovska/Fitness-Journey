package com.sorsix.fitnessjourney

import com.sorsix.fitnessjourney.repository.ExerciseRepository
import com.sorsix.fitnessjourney.repository.FoodRepository
import com.sorsix.fitnessjourney.repository.MuscleRepository
import com.sorsix.fitnessjourney.util.fetchExercisesFromRapidApi
import com.sorsix.fitnessjourney.util.fetchNutritionFromCSV
import fetchMusclesFromRapidApi
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class FitnessJourneyApplication(private val muscleRepository: MuscleRepository, private val exerciseRepository: ExerciseRepository, private val foodRepository: FoodRepository) {

    @PostConstruct
    fun fetchData() {
       // fetchMusclesFromRapidApi(muscleRepository);
       // fetchExercisesFromRapidApi(muscleRepository, exerciseRepository);
       // fetchNutritionFromCSV(foodRepository)
    }
}

fun main(args: Array<String>) {
    runApplication<FitnessJourneyApplication>(*args)
}
