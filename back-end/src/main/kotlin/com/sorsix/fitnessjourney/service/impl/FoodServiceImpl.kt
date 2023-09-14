package com.sorsix.fitnessjourney.service.impl

import com.sorsix.fitnessjourney.model.Food
import com.sorsix.fitnessjourney.repository.FoodRepository
import com.sorsix.fitnessjourney.service.FoodService
import org.springframework.stereotype.Service
import java.util.*

@Service
class FoodServiceImpl (private val foodRepository: FoodRepository): FoodService {

    override fun likeFoods(name: String): List<Food> {
        return this.foodRepository.findByNameIgnoreCaseContaining(name);
    }

    override fun findById(id: Int): Optional<Food> {
        return this.foodRepository.findById(id);
    }


}