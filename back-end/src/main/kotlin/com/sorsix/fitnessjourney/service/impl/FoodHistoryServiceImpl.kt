package com.sorsix.fitnessjourney.service.impl

import com.sorsix.fitnessjourney.model.FoodHistory
import com.sorsix.fitnessjourney.repository.FoodHistoryRepository
import com.sorsix.fitnessjourney.service.FoodHistoryService
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class FoodHistoryServiceImpl(val dailyFoodRepository: FoodHistoryRepository): FoodHistoryService {
    override fun save(dailyFood:FoodHistory): FoodHistory {
        print(dailyFood);
        return this.dailyFoodRepository.save(dailyFood);
    }

    override fun findFoodHistoryByDate(date: String,id:Int): List<FoodHistory> {
        return this.dailyFoodRepository.findByDateAndJournalId(date,id);
    }

    override fun deleteFood(id: Int) {
        this.dailyFoodRepository.deleteById(id)
    }
}