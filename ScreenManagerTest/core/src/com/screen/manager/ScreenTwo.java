package com.screen.manager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class ScreenTwo implements Screen {

    Stage stage;
    Skin skin;
    TextureAtlas buttonAtlas;
    Button backButton;
    public ScreenTwo(final ScreenManagerTest game) {

        stage = new Stage(new StretchViewport(800,480));
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
        Label label = new Label("Screen 2",labelStyle);
        font.getData().setScale(1.0F);
        label.setPosition(338,256);

        stage.addActor(label);
        stage.addActor(backButton);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 128, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
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
        Gdx.input.setInputProcessor(null); // Отключение ui после смены экрана
    }

    @Override
    public void dispose() {
        buttonAtlas.dispose();
        stage.dispose();
    }
}
