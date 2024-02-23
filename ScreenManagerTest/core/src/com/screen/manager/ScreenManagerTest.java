package com.screen.manager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenManagerTest extends Game {

	public SpriteBatch batch;

	@Override
	public void create () {

		batch = new SpriteBatch();
		this.setScreen(new MainScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	public void dispose() {
		batch.dispose();
	}
}