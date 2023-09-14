package com.sorsix.fitnessjourney.model.dtos

import com.sorsix.fitnessjourney.model.enums.Gender
import lombok.Data
import java.time.LocalDate
import java.util.*

@Data
data class UserInfoDto(val username:String, val name:String, val lastname:String,val role:List<String>,
val dateOfBirth:LocalDate, val gender: Gender) {
}