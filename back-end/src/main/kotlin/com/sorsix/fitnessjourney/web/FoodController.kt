package com.sorsix.fitnessjourney.web

import com.sorsix.fitnessjourney.config.JwtUtils
import com.sorsix.fitnessjourney.model.Exercise
import com.sorsix.fitnessjourney.model.Food
import com.sorsix.fitnessjourney.model.User
import com.sorsix.fitnessjourney.model.dto.UserDto
import com.sorsix.fitnessjourney.model.dtos.UserInfoDto
import com.sorsix.fitnessjourney.repository.FoodRepository
import com.sorsix.fitnessjourney.service.ExerciseService
import com.sorsix.fitnessjourney.service.FoodService
import com.sorsix.fitnessjourney.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import javax.servlet.http.Cookie

@RestController
@RequestMapping("/api/foods")
@CrossOrigin(origins = ["http://localhost:4200"])
class FoodController() {

    @Autowired
    private lateinit var foodService: FoodService
    private lateinit var foodRepository: FoodRepository

    @GetMapping("/name/{name}")
    fun likeFoods(@PathVariable name: String): List<Food> {
        return foodService.likeFoods(name)
    }

    @PostMapping
    fun save(@RequestBody food: Food): Food {
        return foodRepository.save(food)
    }
    @GetMapping("/id/{id}")
    fun getFood(@PathVariable id:Int):Food{
        return this.foodService.findById(id).get();
    }
}