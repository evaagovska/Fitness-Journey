package com.sorsix.fitnessjourney.repository

import com.sorsix.fitnessjourney.model.FoodHistory
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.*

interface  FoodHistoryRepository:JpaRepository<FoodHistory,Int>{
    fun findByDateAndJournalId(date: String,id:Int): List<FoodHistory>;
}