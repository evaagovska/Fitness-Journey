package com.sorsix.fitnessjourney.repository

import com.sorsix.fitnessjourney.model.Journal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JournalRepository:JpaRepository<Journal,Number> {


}