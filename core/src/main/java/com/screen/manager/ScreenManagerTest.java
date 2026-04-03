package com.screen.manager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ScreenManagerTest extends Game {

    public SpriteBatch batch;
    public OrthographicCamera camera;
    public StretchViewport viewport;
    public Stage stage;

    @Override
    public void create ()
    {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT);
        viewport = new StretchViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, camera);
        stage = new Stage(new StretchViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, camera));

        Gdx.input.setInputProcessor(stage);

        setScreen (new MainScreen(this));
    }
    @Override
    public void render() {
        ScreenUtils.clear(0.0f, 0.0f, 0.0f, 1);
        if (screen != null) screen.render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width, height, true);
        stage.getViewport().update(width, height, true);
    }
    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }
}
