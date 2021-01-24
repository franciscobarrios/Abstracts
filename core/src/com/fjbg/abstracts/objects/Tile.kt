package com.fjbg.abstracts.objects

import com.badlogic.gdx.Gdx
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

        if (x < 0 || x > Gdx.graphics.width) {
            xSpeed = -xSpeed // if (unexpected) -xSpeed * 0.1f else -xSpeed
        }

        if (y < 0 || y > Gdx.graphics.height) {
            ySpeed =  -ySpeed //if (unexpected) -ySpeed * 0.1f else -ySpeed
        }
    }

    fun creationTime(time: Long): Long {
        return time
    }

    fun draw(shape: ShapeRenderer) {
        shape.rect(x, y, width, height)
        shape.color = color
    }
}