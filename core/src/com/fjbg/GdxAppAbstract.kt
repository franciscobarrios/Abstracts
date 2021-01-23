package com.fjbg

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.Align
import com.fjbg.abstract.common.CONNECT_DISTANCE
import com.fjbg.abstract.common.OBJECTS
import com.fjbg.abstract.objects.Connector
import com.fjbg.abstract.objects.Node
import java.util.*

class GdxAppAbstract : ApplicationAdapter() {
	
	private lateinit var camera: OrthographicCamera
	private lateinit var shape: ShapeRenderer
	private lateinit var nodes: ArrayList<Node>
	private lateinit var batch: SpriteBatch
	private lateinit var font: BitmapFont
	private lateinit var layout: GlyphLayout
	
	override fun create() {
		super.create()
		camera = OrthographicCamera()
		camera.setToOrtho(false, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
		shape = ShapeRenderer()
		batch = SpriteBatch()
		font = BitmapFont()
		nodes = ArrayList()
		
		val random = Random()
		
		for (i in 1..OBJECTS) {
			nodes.add(
				Node(
					id = UUID.randomUUID().toString(),
					x = random.nextInt(Gdx.graphics.width).toFloat(),
					y = random.nextInt(Gdx.graphics.height).toFloat(),
					radius = (random.nextInt(5) + 5).toFloat(),
					xSpeed = (random.nextInt(2) + 1).toFloat(),
					ySpeed = (random.nextInt(2) + 1).toFloat(),
					connections = null
				)
			)
		}
		Gdx.gl.glViewport(0, 0, Gdx.graphics.width, Gdx.graphics.height)
	}
	
	override fun render() {
		super.render()
		Gdx.gl.glEnable(GL20.GL_BLEND)
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
		camera.update()
		
		// Draw nodes and links
		shape.projectionMatrix = camera.combined
		shape.begin(ShapeRenderer.ShapeType.Filled)
		
		val connector = Connector(shape)
		
		for (i in nodes.indices) {
			nodes[i].update()
			nodes[i].drawWithGlow(shape)
			for (j in nodes.indices) {
				val d = connector.distanceBetweenStars(nodes[i], nodes[j])
				if (d <= CONNECT_DISTANCE) {
					connector.connect(nodes[i], nodes[j])
					if (!nodes[i].isThere(nodes[j])) {
						nodes[i].list.add(nodes[j])
					}
				} else {
					if (nodes[i].isThere(nodes[j])) nodes[i].list.remove(nodes[j])
				}
			}
			if (nodes[i].count() == 0) nodes[i].list.clear()
		}
		
		// Draw fields
		for (i in nodes.indices) {
			for (j in nodes.indices) {
				val count = nodes[i].count()
				if (count > 2) {
					val n1 = nodes[i].list[0]
					val n2 = nodes[i].list[1]
					val n3 = nodes[i].list[2]
					connector.createField(n1, n2, n3)
				}
			}
		}
		
		shape.end()
		
		// Draw text
		batch.begin()
		for (node in nodes) {
			val str = """${node.id.substring(0, 15)} ${node.count()}""".trimIndent()
			layout = GlyphLayout(font, str, Color.CYAN, 100f, Align.center, false)
			font.draw(batch, layout, node.x, node.y)
			font.data.setScale(2f)
		}
		batch.end()
	}
	
	override fun dispose() {
		super.dispose()
		batch.dispose()
		font.dispose()
		shape.dispose()
	}
}
