package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.FoodHistory
import java.time.LocalDate
import java.util.*

interface FoodHistoryService {

    fun save(dailyFood: FoodHistory):FoodHistory;
    fun findFoodHistoryByDate(date: String,id:Int): List<FoodHistory>;
    fun deleteFood(id:Int);
}
