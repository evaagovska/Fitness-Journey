package com.sorsix.fitnessjourney.web

import com.sorsix.fitnessjourney.model.Journal
import com.sorsix.fitnessjourney.model.User
import com.sorsix.fitnessjourney.service.UserService
import com.sorsix.fitnessjourney.service.JournalService
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = ["http://localhost:4200"])
class JournalController(val journalService: JournalService,val userService: UserService) {

    @GetMapping("/journal")
    fun getJournal():Journal{
        val auth:Authentication=SecurityContextHolder.getContext().authentication
    val userDetails:User=auth.principal as User
        return userService.loadUserByUsername(userDetails.username).journal
    }

    @PostMapping("/journal/update")
    fun updateJournal(@RequestBody journal:Journal ){
        val auth:Authentication=SecurityContextHolder.getContext().authentication
        val user:User=auth.principal as User
        val prev:Journal=userService.loadUserByUsername(user.username).journal
        journalService.updateJournal(prev.id,journal.height,journal.weight,journal.goal,journal.activity)


    }
}