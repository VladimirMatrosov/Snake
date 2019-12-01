package com.snake.eat.finish.model.entity

data class Food(val x: Int, val y: Int) {
    constructor(): this(-1, -1)
}