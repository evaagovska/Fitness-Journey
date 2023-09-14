package com.sorsix.fitnessjourney.web

import com.sorsix.fitnessjourney.model.FoodHistory
import com.sorsix.fitnessjourney.service.FoodHistoryService
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.util.*

@RestController
@RequestMapping("/api/auth/food-history")
@CrossOrigin(origins = ["http://localhost:4200"])
class FoodHistoryController(val foodHistoryService: FoodHistoryService) {

    @PostMapping("/update")
    fun updateFoodHistory(@RequestBody dailyFood: FoodHistory): FoodHistory{
        print(dailyFood);
        return this.foodHistoryService.save(dailyFood);
    }

    @GetMapping("/date/{date}/{id}")
    fun getFoodHistoryByDate(@PathVariable date: String, @PathVariable id:Int):List<FoodHistory>{
        return this.foodHistoryService.findFoodHistoryByDate(date,id);
    }

    @PostMapping("/delete/{id}")
    fun deleteFoodHistoryElement(@PathVariable id:Int){
        return this.foodHistoryService.deleteFood(id)
    }
}