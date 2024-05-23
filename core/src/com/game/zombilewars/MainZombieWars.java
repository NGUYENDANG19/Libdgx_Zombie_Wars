package com.game.zombilewars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.I18NBundle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.game.zombilewars.handlers.FacebookHandler;
import com.game.zombilewars.handlers.GameServicesHandler;
import com.game.zombilewars.handlers.RequestHandler;
import com.game.zombilewars.screens.MainMenuScreen;
import com.game.zombilewars.screens.Screens;


public class MainZombieWars extends Game {
	public final GameServicesHandler gameServiceHandler;
	public final RequestHandler reqHandler;
	public final FacebookHandler facebookHandler;

	public I18NBundle idiomas;

	public MainZombieWars(RequestHandler reqHandler, GameServicesHandler gameServiceHandler, FacebookHandler facebookHandler) {
		this.reqHandler = reqHandler;
		this.gameServiceHandler = gameServiceHandler;
		this.facebookHandler = facebookHandler;
	}

	public Stage stage;
	public SpriteBatch batcher;

	@Override
	public void create() {
		// idiomas = I18NBundle.createBundle(Gdx.files.internal("strings/strings"));
		stage = new Stage(new StretchViewport(Screens.SCREEN_WIDTH, Screens.SCREEN_HEIGHT));

		batcher = new SpriteBatch();
		Assets.load();
		// Achievements.init(this);

		setScreen(new MainMenuScreen(this));
	}

}
