package com.sorsix.fitnessjourney.model.dto

import com.sorsix.fitnessjourney.model.enums.Gender
import lombok.Data
import java.time.LocalDate
import javax.persistence.EnumType
import javax.persistence.Enumerated
@Data
data class  RegistrationInfo(

    val name:String,
    val surname:String,
    var username:String,
    val password:String,
    @Enumerated(EnumType.STRING)
    val gender: Gender,
    val dateOfBirth:String
)