package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.Muscle

interface MuscleService {

    fun getMuscles():List<Muscle>
    fun getMuscleById(id:Int):Muscle
}