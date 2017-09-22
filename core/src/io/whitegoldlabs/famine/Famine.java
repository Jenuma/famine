package io.whitegoldlabs.famine;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.whitegoldlabs.famine.util.Assets;
import io.whitegoldlabs.famine.view.TestScreen;

public class Famine extends Game
{
	// ------------------------------------------------------------------------------------------//
	// Public Fields                                                                             //
	// ------------------------------------------------------------------------------------------//
	public Assets assets;                                                                        //
	                                                                                             //
	public Screen currentScreen;                                                                 //
	public Engine engine;                                                                        //
	                                                                                             //
	public OrthographicCamera camera;                                                            //
	public SpriteBatch batch;                                                                    //
	// ------------------------------------------------------------------------------------------//
	
	@Override
	public void create()
	{
		this.assets = new Assets();
		assets.load();
		
		this.camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		batch = new SpriteBatch();
		
		this.engine = new Engine();
		
		// Set the first screen of the game.
		TestScreen testScreen = new TestScreen(this);
		this.currentScreen = testScreen;
		this.setScreen(currentScreen);
	}

	@Override
	public void render()
	{
		super.render();
	}
	
	@Override
	public void dispose()
	{
		batch.dispose();
	}
}
