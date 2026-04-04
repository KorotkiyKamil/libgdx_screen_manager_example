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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainScreen implements Screen {

    private ScreenManagerTest game;
    private SpriteBatch batch;
    private Stage stage;
    private OrthographicCamera camera;
    private TextureAtlas buttonAtlas;

    static Skin skin;

    TextButton.TextButtonStyle style;
    TextButton ScreenOneButton, ScreenTwoButton, ScreenThreeButton;

    public MainScreen(ScreenManagerTest game) {

        this.game = game;
        this.stage = game.stage;
        this.batch = game.batch;
        this.camera = game.camera;
        this.buttonAtlas = game.buttonAtlas;

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


    }

    @Override
    public void show() {
        stage.clear();

        stage.addActor(ScreenOneButton);
        stage.addActor(ScreenTwoButton);
        stage.addActor(ScreenThreeButton);
    }

    @Override
    public void render(float delta) {
        game.viewport.apply(true);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        //batch.draw();
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
       // Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {

        buttonAtlas.dispose();
    }
}
