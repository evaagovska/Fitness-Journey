package com.sorsix.fitnessjourney.web
import org.springframework.data.domain.Pageable
import com.sorsix.fitnessjourney.model.Exercise
import com.sorsix.fitnessjourney.model.Muscle
import com.sorsix.fitnessjourney.service.ExerciseService
import com.sorsix.fitnessjourney.service.MuscleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/exercises")
@CrossOrigin(origins = ["http://localhost:4200"])
class ExerciseController() {

    @Autowired
    private lateinit var exerciseService: ExerciseService

    @GetMapping("")
    fun getExercises():List<Exercise>{
        return this.exerciseService.getExercises();
    }

    @GetMapping("/muscle/{muscleId}")
    fun getExercisesByMuscleId(
        @PathVariable muscleId: Int,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "5") size: Int
    ): ResponseEntity<Page<Exercise>> {
        val pageable: Pageable = PageRequest.of(page, size)
        val exercises = exerciseService.getExercisesByMuscleId(muscleId, pageable)
        return ResponseEntity.ok(exercises)
    }

    // filter by category for exercises
    @GetMapping("/muscle/{muscleId}/category/{category}")
    fun getExercisesByMuscleId(@PathVariable muscleId: Int, @PathVariable category: String): List<Exercise> {
        return exerciseService.getExercisesByMuscleIdAndCategory(muscleId, category)
    }
}