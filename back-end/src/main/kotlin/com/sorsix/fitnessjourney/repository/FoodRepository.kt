package com.sorsix.fitnessjourney.repository

import com.sorsix.fitnessjourney.model.Food
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodRepository : JpaRepository<Food, Int> {

    fun findByNameIgnoreCaseContaining(name: String): List<Food>
}