package com.sorsix.fitnessjourney.model

import com.sorsix.fitnessjourney.model.enums.Activity_Level
import com.sorsix.fitnessjourney.model.enums.Goal
import javax.persistence.*


@Entity
data class Journal(
    @GeneratedValue
    @Id
    val id: Int = 0,
    val height: Int = 0,
    val weight: Int = 0,
    @Enumerated(EnumType.STRING)
    val goal: Goal = Goal.MAINTAIN,
@Enumerated(EnumType.STRING)
val activity:Activity_Level=Activity_Level.NO_ACTIVITY
) {
    constructor() : this(0, 0, 0, Goal.MAINTAIN,Activity_Level.NO_ACTIVITY)
}