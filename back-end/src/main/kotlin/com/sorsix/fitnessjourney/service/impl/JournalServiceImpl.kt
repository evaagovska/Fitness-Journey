package com.sorsix.fitnessjourney.service.impl

import com.sorsix.fitnessjourney.model.Journal
import com.sorsix.fitnessjourney.model.enums.Activity_Level
import com.sorsix.fitnessjourney.model.enums.Goal
import com.sorsix.fitnessjourney.repository.JournalRepository
import com.sorsix.fitnessjourney.service.JournalService
import org.springframework.stereotype.Service

@Service
class JournalServiceImpl(val journalRepository: JournalRepository): JournalService {

     override fun updateJournal(id:Int, height:Int, weight:Int, goal: Goal, activity:Activity_Level): Journal{
         val journal=Journal(id,height,weight,goal,activity)
         return this.journalRepository.save(journal);

    }
}