package com.sorsix.fitnessjourney.model


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Food(
    @GeneratedValue
    @Id
    val id: Int = 0,
    val name: String = "",
    val calories: Int = 0,
    val proteins: String = "",
    val fats: String = "",
    val carbohydrates: String = ""
) {
    constructor(name: String, calories: Int, proteins: String, fats: String, carbohydrates: String)
    : this(0, name, calories, proteins, fats, carbohydrates)
}