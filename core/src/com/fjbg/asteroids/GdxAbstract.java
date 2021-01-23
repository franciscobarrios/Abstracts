package com.fjbg.asteroids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.fjbg.asteroids.objects.Connector;
import com.fjbg.asteroids.objects.Node;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import static com.fjbg.asteroids.common.CommonsKt.CONNECT_DISTANCE;
import static com.fjbg.asteroids.common.CommonsKt.OBJECTS;

public class GdxAsteroids extends ApplicationAdapter {
    private OrthographicCamera camera;
    private ShapeRenderer shape;
    private ArrayList<Node> nodes;
    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shape = new ShapeRenderer();
        nodes = new ArrayList<>();
        batch = new SpriteBatch();

        font = new BitmapFont();


        Random random = new Random();
        for (int i = 0; i < OBJECTS; i++) {
            nodes.add(
                    new Node(
                            UUID.randomUUID().toString(),
                            random.nextInt(Gdx.graphics.getWidth()),
                            random.nextInt(Gdx.graphics.getHeight()),
                            random.nextInt(5) + 2,
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

        batch.begin();
        font.setColor(Color.WHITE);


        Connector connector = new Connector();
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).update();
            nodes.get(i).drawWithGlow(shape);

            font.draw(batch, nodes.get(i).getId(), 500, 500);


            for (int j = 0; j < nodes.size(); j++) {
                float d = connector.distanceBetweenStars(nodes.get(i), nodes.get(j));
                if (d <= CONNECT_DISTANCE) {
                    connector.connect(nodes.get(i), nodes.get(j), shape);
                    nodes.get(i).handleList(nodes.get(j));
                }
            }

            //System.out.println(" list size: " + nodes.get(i).getList().size());
        }
        shape.end();
        batch.end();
    }

    @Override
    public void dispose() {
    }
}
