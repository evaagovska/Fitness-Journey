package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.Exercise
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page

interface ExerciseService {

    fun getExercises():List<Exercise>
    fun getExercisesByMuscleId(muscleId: Int, pageable: Pageable): Page<Exercise>
    fun getExercisesByMuscleIdAndCategory(muscleId: Int, category: String): List<Exercise>
}