package com.fjbg.abstracts.base

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

abstract class GdxAppBase : ApplicationAdapter() {

    abstract fun camera(): OrthographicCamera

    abstract fun shape(): ShapeRenderer

    abstract fun objects()

    override fun create() {
        super.create()
        camera()
        shape()
        objects()
    }
}
