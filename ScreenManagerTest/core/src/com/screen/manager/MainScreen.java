package com.screen.manager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MainScreen implements Screen {
    Stage stage;
    Skin skin;
    TextureAtlas buttonAtlas;

    TextButton.TextButtonStyle style;
    TextButton ScreenOneButton, ScreenTwoButton, ScreenThreeButton;

    public MainScreen(final ScreenManagerTest game) {

        stage = new Stage(new StretchViewport(800,480));
        buttonAtlas = new TextureAtlas(Gdx.files.internal("button.atlas"));
        BitmapFont font = new BitmapFont(Gdx.files.internal("lsans-32.fnt"));
        skin = new Skin();
        skin.addRegions(buttonAtlas);

        style = new TextButton.TextButtonStyle();
        style.font = font;
        font.getData().setScale(0.8f);
        style.up = skin.getDrawable("menu_button_up");
        style.down = skin.getDrawable("menu_button_down");

        ScreenOneButton =  new TextButton("ScreenOne",style);
        ScreenOneButton.setSize(192, 64);
        ScreenOneButton.setPosition(304, 264);
        ScreenOneButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {

                ((Game)Gdx.app.getApplicationListener()).setScreen(new ScreenOne(game));
            }
        });

        ScreenTwoButton = new TextButton("ScreenTwo",style);
        ScreenTwoButton.setSize(192, 64);
        ScreenTwoButton.setPosition(304, 180);
        ScreenTwoButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {

                ((Game)Gdx.app.getApplicationListener()).setScreen(new ScreenTwo(game));
            }
        });

        ScreenThreeButton = new TextButton("ScreenThree",style);
        ScreenThreeButton.setSize(192, 64);
        ScreenThreeButton.setPosition(304, 96);
        ScreenThreeButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {

                ((Game)Gdx.app.getApplicationListener()).setScreen(new ScreenThree(game));
            }
        });

        stage.addActor(ScreenOneButton);
        stage.addActor(ScreenTwoButton);
        stage.addActor(ScreenThreeButton);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
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
        stage.dispose();
    }
}