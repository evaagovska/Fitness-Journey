package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.FoodHistory
import com.sorsix.fitnessjourney.model.Journal
import com.sorsix.fitnessjourney.model.enums.Activity_Level
import com.sorsix.fitnessjourney.model.enums.Goal

interface JournalService {

    fun updateJournal(id:Int,height:Int, weight:Int, goal: Goal,activity:Activity_Level):Journal;
}