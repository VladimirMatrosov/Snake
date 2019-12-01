package com.snake.eat.finish.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Result(@PrimaryKey(autoGenerate = true) var id: Int?, val name: String, val scores: Int) {
}