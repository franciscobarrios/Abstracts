package com.fjbg.abstracts.objects

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.fjbg.abstracts.common.objectColor
import kotlin.random.Random

data class Node(
    var id: String,
    var x: Float,
    var y: Float,
    var radius: Float,
    var xSpeed: Float,
    var ySpeed: Float,
    val connections: List<Node>?
) {

    val list = arrayListOf<Node>()

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

    fun drawWithGlow(shape: ShapeRenderer) {
        for (i in 1..100) {
            shape.color = objectColor(1f / i)
            shape.circle(x, y, radius * (i.toFloat() / 10))
        }
    }

    fun count() = list.size

    fun isThere(node: Node): Boolean = list.contains(node)
}