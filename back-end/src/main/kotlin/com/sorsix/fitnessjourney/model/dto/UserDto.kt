package com.sorsix.fitnessjourney.model.dto
import lombok.Data

@Data
data class UserDto(

    val username:String,
    val password:String,
) {
}