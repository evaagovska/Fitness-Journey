package com.sorsix.fitnessjourney.model


import java.util.Collections.emptyList
import javax.persistence.*

@Entity
data class Exercise(
    @GeneratedValue
    @Id
    val id: Int = 0,
    val name:String = "",
    val category:String = "",
    val force:String = "",
    @ElementCollection
    val steps: List<String> = emptyList(),
    @ElementCollection
    val videos: List<String> = emptyList(),
    @OneToOne
    val muscle: Muscle = Muscle()
) {
    constructor(name: String, category: String, force: String, steps: List<String>, videos: List<String>, muscle: Muscle)
            : this(0, name, category, force, steps, videos, muscle)
}
