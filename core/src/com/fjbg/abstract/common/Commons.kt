package com.fjbg.abstract.common

import com.badlogic.gdx.graphics.Color

const val CONNECT_DISTANCE = 400
const val OBJECTS = 20

fun objectColor(alpha: Float): Color {
	return Color(0f, 1f, 1f, alpha)
}

fun backgroundColor(): Color {
	return Color(0f, 1f, 0f, 1f)
}