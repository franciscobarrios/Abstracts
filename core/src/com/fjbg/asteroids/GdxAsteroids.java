package com.fjbg.asteroids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class GdxAsteroids extends ApplicationAdapter {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Rectangle rectangle;

    @Override
    public void create() {

        ShapeRenderer sr = new ShapeRenderer();
        sr.circle(10, 10, 10);
        sr.setColor(Color.CYAN);


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        batch = new SpriteBatch();

        rectangle = new Rectangle(0, 0, 100, 100);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sr.
        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void dispose() {
    }
}
