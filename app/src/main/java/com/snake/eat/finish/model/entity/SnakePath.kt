package com.snake.eat.finish.model.entity

import com.snake.eat.finish.view.SnakeView

data class SnakePath(var x: Int, var y: Int, var mDirection: Int, var isStartPath: Boolean ) {
    constructor(x: Int, y: Int): this(x, y, SnakeView.RIGHT_DIRECTION, false)
}