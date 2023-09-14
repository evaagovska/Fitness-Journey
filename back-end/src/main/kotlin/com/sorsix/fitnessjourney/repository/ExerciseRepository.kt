package com.sorsix.fitnessjourney.repository

import com.sorsix.fitnessjourney.model.Exercise;
import jdk.jfr.Category
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

@Repository
interface ExerciseRepository : JpaRepository<Exercise, Number> {
    fun findByMuscleId(muscleId: Int, pageable: Pageable): Page<Exercise>
    fun findByMuscleIdAndCategory(muscleId: Int, category: String): List<Exercise>
}