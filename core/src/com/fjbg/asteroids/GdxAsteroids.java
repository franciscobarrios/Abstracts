package com.fjbg.asteroids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.fjbg.asteroids.objects.SpaceObject;

public class GdxAsteroids extends ApplicationAdapter {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Rectangle rectangle;
    private ShapeRenderer shapeRenderer;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        //batch = new SpriteBatch();
    }

    @Override
    public void render() {


        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        SpaceObject spaceObject = new SpaceObject();
        spaceObject.star();

        //batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void dispose() {
    }
}
