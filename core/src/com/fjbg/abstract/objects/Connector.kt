package com.fjbg.abstract.objects

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.fjbg.abstract.common.CONNECT_DISTANCE
import com.fjbg.abstract.common.objectColor
import kotlin.math.sqrt

data class Connector(
    val shape: ShapeRenderer
) {
	
	val linked = arrayListOf<Pair<Node, Node>>()
	
	fun distanceBetweenStars(n1: Node, n2: Node) = sqrt((n1.y - n2.y) * (n1.y - n2.y) + (n1.x - n2.x) * (n1.x - n2.x))
	
	fun connect(n1: Node, n2: Node) {
		val d = distanceBetweenStars(n1, n2)
		val alpha = when {
			d < 100 -> 1f
			d >= 100 && d < 200 -> 0.75f
			d >= 200 && d < 300 -> 0.5f
			d >= 300 && d < CONNECT_DISTANCE -> 0.25f
			else -> 0.1f
		}
		
		shape.color = objectColor(alpha)
		shape.rectLine(n1.x, n1.y, n2.x, n2.y, 2f)
		linked.add(Pair(n1, n2))
	}
	
	
	fun connectedFiled(n1: Node, n2: Node, n3: Node): Triple<Node, Node, Node> = Triple(n1, n2, n3)
	
	fun createField(n1: Node, n2: Node, n3: Node) {
		val d = distanceBetweenStars(n1, n2)
		val alpha = when {
			d < 100 -> 0.2f
			d >= 100 && d < 200 -> 0.1f
			d >= 200 && d < 300 -> 0.05f
			d >= 300 && d < CONNECT_DISTANCE -> 0.02f
			else -> 0.01f
		}
		shape.triangle(
            n1.x, n1.y,
            n2.x, n2.y,
            n3.x, n3.y
        )
		shape.color = objectColor(0.1f)
	}
}

