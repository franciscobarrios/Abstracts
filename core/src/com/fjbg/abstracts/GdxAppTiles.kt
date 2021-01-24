package com.fjbg.abstracts

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.TimeUtils
import com.fjbg.abstracts.common.randomColor
import com.fjbg.abstracts.objects.Tile
import kotlin.random.Random

class GdxAppTiles : ApplicationAdapter() {

    private lateinit var camera: OrthographicCamera
    private lateinit var shape: ShapeRenderer
    private lateinit var batch: SpriteBatch
    private lateinit var tileList: ArrayList<Tile>
    private var sceneCreationTime = 0L

    override fun create() {
        super.create()
        camera = OrthographicCamera()
        camera.setToOrtho(false, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        shape = ShapeRenderer()
        batch = SpriteBatch()
        Gdx.gl.glViewport(0, 0, Gdx.graphics.width, Gdx.graphics.height)
        tileList = ArrayList()
    }

    override fun render() {
        super.render()
        Gdx.gl.glEnable(GL20.GL_BLEND)
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA)
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        camera.update()

        shape.begin(ShapeRenderer.ShapeType.Filled)
        shape.setAutoShapeType(true)
        shape.projectionMatrix = camera.combined

        if (currentTime() - sceneCreationTime > 500) {
            createTile()
        }

        tileList.forEach {
            it.update()
            it.draw(shape)
        }

        shape.end()
    }

    override fun dispose() {
        super.dispose()
        batch.dispose()
        shape.dispose()
    }

    private fun currentTime(): Long {
        return TimeUtils.millis()
    }

    private fun createTile() {

        sceneCreationTime = currentTime()

        val tile = Tile(
            x = Gdx.graphics.width.toFloat() / 2,
            y = Gdx.graphics.height.toFloat() / 2,
            width = (Random.nextInt(200) + 100).toFloat(),
            height = (Random.nextInt(200) + 100).toFloat(),
            xSpeed = (Random.nextInt(5) + 2).toFloat(),
            ySpeed = (Random.nextInt(5) + 2).toFloat(),
            color = randomColor(),
            creationTime = null
        )
        tile.creationTime(sceneCreationTime)
        tileList.add(tile)
    }
}