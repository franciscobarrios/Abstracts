package com.fjbg.asteroids.objects

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class Star(
        var x: Float,
        var y: Float,
        var radius: Float,
        var xSpeed: Float,
        var ySpeed: Float
) {
    fun update() {
        x += xSpeed
        y += ySpeed
        if (x < 0 || x > Gdx.graphics.width) {
            xSpeed = -xSpeed;
        }
        if (y < 0 || y > Gdx.graphics.height) {
            ySpeed = -ySpeed;
        }
    }

    fun draw(shape: ShapeRenderer) {
        shape.setColor(0f, 1f, 1f, 1f)
        shape.circle(x, y, radius)
        shape.setColor(0f, 1f, 1f, 0.3f)
        shape.circle(x, y, radius + 10)
        shape.setColor(0f, 1f, 1f, 0.15f)
        shape.circle(x, y, radius + 20)
        shape.setColor(0f, 1f, 1f, 0.05f)
        shape.circle(x, y, radius + 30)
        shape.setColor(1f, 1f, 1f, 0.08f)
        shape.circle(x, y, radius + 40)
        shape.setColor(1f, 1f, 1f, 0.01f)
        shape.circle(x, y, radius - 6)
    }
}