package com.fjbg.asteroids.objects

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import kotlin.math.sqrt

class Connector {
    fun connect(firstStar: Star, secondStar: Star, shape: ShapeRenderer) {
        shape.setColor(0f, 1f, 1f, 0.4f)
        shape.rectLine(firstStar.x, firstStar.y, secondStar.x, secondStar.y, 1f)
    }

    fun distanceBetweenStars(firstStar: Star, secondStar: Star) = sqrt((firstStar.y - secondStar.y) * (firstStar.y - secondStar.y) + (firstStar.x - secondStar.x) * (firstStar.x - secondStar.x))

    fun distanceToTouch(x: Int, y: Int, star: Star) = sqrt((y - star.y) * (y - star.y) + (x - star.x) * (x - star.x))
}

