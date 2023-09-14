package com.sorsix.fitnessjourney.util

import com.sorsix.fitnessjourney.repository.FoodRepository
import com.opencsv.CSVReader
import com.sorsix.fitnessjourney.model.Food
import java.io.FileReader

fun fetchNutritionFromCSV(foodRepository: FoodRepository) {
    val csvReader = CSVReader(FileReader("src/main/resources/csv/nutrition.csv"))
    var record: Array<String>?
    var num = true
    while (csvReader.readNext().also { record = it } != null) {
        if (num) {
            num = false
            continue
        }
        val food = Food(name = record!![1], calories = record!![3].toInt(), proteins = record!![38], fats = record!![4], carbohydrates = record!![58])
        foodRepository.save(food);
    }
}