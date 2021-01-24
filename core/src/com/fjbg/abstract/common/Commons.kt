package com.fjbg.abstract.common

import com.badlogic.gdx.graphics.Color
import kotlin.random.Random

const val CONNECT_DISTANCE = 400
const val OBJECTS = 100

fun objectColor(alpha: Float): Color {
    return Color(0f, 1f, 1f, alpha)
}

fun backgroundColor(): Color {
    return Color(0f, 1f, 0f, 1f)
}

fun randomColor(): Color {
    val red = Random.nextFloat()
    val green = Random.nextFloat()
    val blue = Random.nextFloat()
    return Color(red, green, blue, 1f)
}