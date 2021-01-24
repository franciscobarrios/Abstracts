package com.fjbg.abstracts.objects

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

data class Square(
    var x: Float,
    var y: Float,
    var width: Float,
    var height: Float,
    var color: Color,
    var columnColor: Color
) {

    fun draw(shape: ShapeRenderer) {
        //shape.rect(x, y, width, height, columnColor, columnColor, columnColor, columnColor)
        shape.line(x, y, x + width, y + height)
        shape.line(x, y + height, x + width, y)
    }
}