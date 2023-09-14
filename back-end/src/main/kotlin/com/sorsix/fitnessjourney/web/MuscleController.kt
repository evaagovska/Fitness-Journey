package com.sorsix.fitnessjourney.web

import com.sorsix.fitnessjourney.model.Muscle
import com.sorsix.fitnessjourney.service.MuscleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/muscles")
class MuscleController() {

    @Autowired
    private lateinit var muscleService: MuscleService

    @GetMapping("")
    fun getMuscles():List<Muscle>{
        return this.muscleService.getMuscles();
    }

    @GetMapping("/{id}")
    fun getMuscleById(@PathVariable id: Int): Muscle {
        return muscleService.getMuscleById(id);
    }
}