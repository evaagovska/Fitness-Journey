package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.Exercise
import com.sorsix.fitnessjourney.repository.ExerciseRepository
import org.springframework.stereotype.Service
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Page

@Service
class ExerciseServiceImpl(val exerciseRepository: ExerciseRepository):ExerciseService {

    override fun getExercises():List<Exercise> {
        return  this.exerciseRepository.findAll();
    }
    override fun getExercisesByMuscleId(muscleId: Int, pageable: Pageable): Page<Exercise> {
        return exerciseRepository.findByMuscleId(muscleId, pageable)
    }

    override fun getExercisesByMuscleIdAndCategory(muscleId: Int, category: String): List<Exercise> {
        return this.exerciseRepository.findByMuscleIdAndCategory(muscleId, category);
    }
}