package com.fjbg.abstract.objects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

data class Tile(
    var x: Float,
    var y: Float,
    var width: Float,
    var height: Float,
    var xSpeed: Float,
    var ySpeed: Float,
    var color: Color,
    var creationTime: Long?
) {
    fun update() {
        x += xSpeed
        y += ySpeed
    }

    fun creationTime(time: Long) :Long{
        return time
    }

    fun draw(shape: ShapeRenderer) {
        shape.rect(x, y, width, height)
        shape.color = color
    }
}