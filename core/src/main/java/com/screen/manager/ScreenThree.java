package com.screen.manager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ScreenThree implements Screen {

    private ScreenManagerTest game;
    static Stage stage;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private StretchViewport viewport;
    static Skin skin;
    static TextureAtlas buttonAtlas;
    static Button backButton;
    static Label label;

    public ScreenThree(ScreenManagerTest game) {

        this.game = game;
        this.stage = game.stage;
        this.batch = game.batch;
        this.viewport = game.viewport;

        batch = game.batch;
        this.camera = game.camera;

        buttonAtlas = new TextureAtlas(Gdx.files.internal("button.atlas"));
        skin = new Skin();
        skin.addRegions(buttonAtlas);

        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = skin.getDrawable("turn_left");
        style.down = skin.getDrawable("turn_left");

        backButton  = new Button(style);
        backButton.setSize(102, 96);
        backButton.setPosition(672, 32);
        backButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {

                ((Game)Gdx.app.getApplicationListener()).setScreen(new MainScreen(game));
            }
        });

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        BitmapFont font = new BitmapFont(Gdx.files.internal("lsans-32.fnt"));
        labelStyle.font = font;
        label = new Label("Screen 3",labelStyle);
        font.getData().setScale(1.0F);
        label.setPosition(338,256);
    }

    @Override
    public void show() {
        stage.clear();
        stage.addActor(label);
        stage.addActor(backButton);
    }

    @Override
    public void render(float delta) {
        viewport.apply(true);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.end();

        stage.getViewport().apply();
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        // Gdx.input.setInputProcessor(null); // Отключение ui после смены экрана
    }

    @Override
    public void dispose() {
        buttonAtlas.dispose();
    }
}
