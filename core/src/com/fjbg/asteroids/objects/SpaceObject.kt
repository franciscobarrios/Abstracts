package com.fjbg.asteroids.objects

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class SpaceObject {

    fun star() {
        val shapeRenderer = ShapeRenderer()
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        shapeRenderer.setAutoShapeType(true)
        shapeRenderer.setColor(1f, 1f, 1f, 1f)
        shapeRenderer.circle(600f, 600f, 10f)
        shapeRenderer.end()
    }
}