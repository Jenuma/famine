package io.whitegoldlabs.famine.view;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;

import io.whitegoldlabs.famine.Famine;
import io.whitegoldlabs.famine.component.PositionComponent;
import io.whitegoldlabs.famine.component.SpriteComponent;
import io.whitegoldlabs.famine.system.RenderSystem;
import io.whitegoldlabs.famine.util.Assets;

public class TestScreen implements Screen
{
	final Famine game;
	
	public TestScreen(final Famine game)
	{
		this.game = game;
		
		// Map size: 15x10 tiles
		Entity map = new Entity();
		map.add(new PositionComponent(0, 0));
		map.add(new SpriteComponent(new Sprite(game.assets.assetManager.get(Assets.mapTest))));
		
		game.engine.addEntity(map);
		game.engine.addSystem(new RenderSystem(game));
	}
	
	@Override
	public void show()
	{
		
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.engine.update(delta);
	}

	@Override
	public void resize(int width, int height)
	{
		
	}

	@Override
	public void pause()
	{
		
	}

	@Override
	public void resume()
	{
		
	}

	@Override
	public void hide()
	{
		
	}

	@Override
	public void dispose()
	{
		
	}
}
