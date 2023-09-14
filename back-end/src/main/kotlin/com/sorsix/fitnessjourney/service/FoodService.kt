package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.Food
import org.springframework.stereotype.Service
import java.util.*

interface FoodService {

    fun likeFoods(name: String): List<Food>
    fun findById(id:Int): Optional<Food>
}