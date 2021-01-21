package com.fjbg.asteroids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.fjbg.asteroids.objects.Connector;
import com.fjbg.asteroids.objects.Star;

import java.util.ArrayList;
import java.util.Random;

public class GdxAsteroids extends ApplicationAdapter {
    private OrthographicCamera camera;
    private ShapeRenderer shape;
    private ArrayList<Star> stars;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shape = new ShapeRenderer();
        stars = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            stars.add(
                    new Star(
                            random.nextInt(Gdx.graphics.getWidth()),
                            random.nextInt(Gdx.graphics.getHeight()),
                            random.nextInt(12) + 8,
                            random.nextInt(2) + 1,
                            random.nextInt(2) + 1
                    )
            );
        }
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render() {
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        shape.setProjectionMatrix(camera.combined);
        shape.begin(ShapeRenderer.ShapeType.Filled);

        Connector connector = new Connector();
        for (int i = 0; i < stars.size(); i++) {
            stars.get(i).update();
            stars.get(i).draw(shape);
            for (int j = 0; j < stars.size(); j++) {
                float d = connector.distanceBetweenStars(stars.get(i), stars.get(j));
                if (d <= 300) {

                    connector.connect(stars.get(i), stars.get(j), shape);
                }
            }
        }
        shape.end();
    }

    @Override
    public void dispose() {
    }
}
