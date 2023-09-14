package com.sorsix.fitnessjourney.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class FoodHistory(
    @Id
    @GeneratedValue
    val id: Int = 0,
    @ManyToOne
    val food: Food = Food(),
    val portion_size: Double = 100.0,
    var date: String = LocalDate.now().toString(),
    @OneToOne
val journal:Journal
) {
    constructor() : this(0, Food(), 100.0, LocalDate.now().toString(),Journal())
}