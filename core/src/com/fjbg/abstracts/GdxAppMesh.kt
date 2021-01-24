package com.fjbg.abstracts

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.utils.TimeUtils
import com.fjbg.abstracts.common.objectColor
import com.fjbg.abstracts.objects.Square


const val SQR_WIDTH = 10
const val SQR_HEIGHT = 25

class GdxAppMesh : ApplicationAdapter() {

    private lateinit var camera: OrthographicCamera
    private lateinit var shape: ShapeRenderer
    private lateinit var batch: SpriteBatch
    private lateinit var squareList: ArrayList<Square>
    private var elapse = 0L

    override fun create() {

        camera = OrthographicCamera()
        camera.setToOrtho(false, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        shape = ShapeRenderer()
        batch = SpriteBatch()
        Gdx.gl.glViewport(0, 0, Gdx.graphics.width, Gdx.graphics.height)
        squareList = ArrayList()

        Gdx.gl.glViewport(
            0,
            0,
            Gdx.graphics.width,
            Gdx.graphics.height
        )

        for (i in 0..SQR_WIDTH) {
            for (j in 0..SQR_HEIGHT) {
                squareList.add(
                    createSquare(
                        x = (Gdx.graphics.width.toFloat() / SQR_WIDTH) * i,
                        y = (Gdx.graphics.height.toFloat() / SQR_HEIGHT) * j
                    )
                )
            }
        }
    }

    private fun createSquare(x: Float, y: Float) = Square(
        x = x,
        y = y,
        width = Gdx.graphics.width.toFloat() / SQR_WIDTH,
        height = Gdx.graphics.height.toFloat() / SQR_HEIGHT,
        color = objectColor(1f),
        columnColor = Color(1f, 1f, 1f, 0.5f)
    )

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        camera.update()

        shape.projectionMatrix = camera.combined
        shape.begin(ShapeRenderer.ShapeType.Line)

        for (i in 0 until squareList.size) {
            squareList[i].draw(shape)
        }
        shape.end()

        if (Gdx.input.isTouched) {
            val touchPos = Vector3()
            touchPos[Gdx.input.x.toFloat(), Gdx.input.y.toFloat()] = 0f
            camera.unproject(touchPos)


        }

    }

    private fun currentTime(): Long {
        return TimeUtils.millis()
    }

    override fun dispose() {
        shape.dispose()
    }
}