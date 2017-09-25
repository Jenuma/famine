package io.whitegoldlabs.famine.view;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

import io.whitegoldlabs.famine.Famine;
import io.whitegoldlabs.famine.component.AnimationComponent;
import io.whitegoldlabs.famine.component.PositionComponent;
import io.whitegoldlabs.famine.component.SpriteComponent;
import io.whitegoldlabs.famine.component.StateComponent;
import io.whitegoldlabs.famine.component.StateComponent.State;
import io.whitegoldlabs.famine.system.AnimationSystem;
import io.whitegoldlabs.famine.system.MovementSystem;
import io.whitegoldlabs.famine.system.RenderSystem;
import io.whitegoldlabs.famine.util.Assets;
import io.whitegoldlabs.famine.util.Mappers;

public class TestScreen implements Screen
{
	final Famine game;
	Entity unit;
	
	public TestScreen(final Famine game)
	{
		this.game = game;
		
		// Map size: 15x10 tiles
		Entity map = new Entity();
		map.add(new PositionComponent(0, 0));
		map.add(new SpriteComponent(new Sprite(game.assets.assetManager.get(Assets.mapTest))));
		
		// Test Sprite
		unit = new Entity();
		unit.add(new PositionComponent(16, 32));
		unit.add(new StateComponent());
		
		Texture unitSpriteSheet = game.assets.assetManager.get(Assets.unitTest);
		
		Array<Sprite> stillSprites = new Array<>();
		stillSprites.add(new Sprite(unitSpriteSheet, 0, 0, 64, 64));
		stillSprites.add(new Sprite(unitSpriteSheet, 64, 0, 64, 64));
		stillSprites.add(new Sprite(unitSpriteSheet, 128, 0, 64, 64));
		stillSprites.add(new Sprite(unitSpriteSheet, 128, 0, 64, 64));
		
		Array<Sprite> movingLeftSprites = new Array<>();
		movingLeftSprites.add(new Sprite(unitSpriteSheet, 0, 65, 64, 64));
		movingLeftSprites.add(new Sprite(unitSpriteSheet, 64, 65, 64, 64));
		movingLeftSprites.add(new Sprite(unitSpriteSheet, 128, 65, 64, 64));
		movingLeftSprites.add(new Sprite(unitSpriteSheet, 192, 65, 64, 64));
		
		Array<Sprite> movingDownSprites = new Array<>();
		movingDownSprites.add(new Sprite(unitSpriteSheet, 0, 129, 64, 64));
		movingDownSprites.add(new Sprite(unitSpriteSheet, 64, 129, 64, 64));
		movingDownSprites.add(new Sprite(unitSpriteSheet, 128, 129, 64, 64));
		movingDownSprites.add(new Sprite(unitSpriteSheet, 192, 129, 64, 64));
		
		Array<Sprite> movingUpSprites = new Array<>();
		movingUpSprites.add(new Sprite(unitSpriteSheet, 0, 193, 64, 64));
		movingUpSprites.add(new Sprite(unitSpriteSheet, 64, 193, 64, 64));
		movingUpSprites.add(new Sprite(unitSpriteSheet, 128, 193, 64, 64));
		movingUpSprites.add(new Sprite(unitSpriteSheet, 192, 193, 64, 64));
		
		AnimationComponent animationComponent = new AnimationComponent();
		animationComponent.animations.put("STILL", new Animation<Sprite>(1f/8f, stillSprites, Animation.PlayMode.LOOP_PINGPONG));
		animationComponent.animations.put("MOVING_UP", new Animation<Sprite>(1f/16f, movingUpSprites, Animation.PlayMode.NORMAL));
		animationComponent.animations.put("MOVING_DOWN", new Animation<Sprite>(1f/16f, movingDownSprites, Animation.PlayMode.NORMAL));
		animationComponent.animations.put("MOVING_LEFT", new Animation<Sprite>(1f/16f, movingLeftSprites, Animation.PlayMode.NORMAL));
		animationComponent.animations.put("MOVING_RIGHT", new Animation<Sprite>(1f/16f, movingLeftSprites, Animation.PlayMode.NORMAL));
		
		unit.add(animationComponent);
		unit.add(new SpriteComponent(new Sprite(unitSpriteSheet, 16, 0, 64, 64)));
		
		// Add test entities to the game engine.
		game.engine.addEntity(map);
		game.engine.addEntity(unit);
		game.engine.addSystem(new MovementSystem(game));
		game.engine.addSystem(new RenderSystem(game));
		game.engine.addSystem(new AnimationSystem(game));
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
		
		// Test movement.
		StateComponent unitStateComponent = Mappers.state.get(unit);
		
		if(!game.unitIsMoving)
		{
			if(Gdx.input.isKeyJustPressed(Keys.UP))
			{
				unitStateComponent.state  = State.MOVING_UP;
				game.unitIsMoving = true;
			}
			else if(Gdx.input.isKeyJustPressed(Keys.DOWN))
			{
				unitStateComponent.state  = State.MOVING_DOWN;
				game.unitIsMoving = true;
			}
			else if(Gdx.input.isKeyJustPressed(Keys.LEFT))
			{
				unitStateComponent.state  = State.MOVING_LEFT;
				game.unitIsMoving = true;
			}
			else if(Gdx.input.isKeyJustPressed(Keys.RIGHT))
			{
				unitStateComponent.state  = State.MOVING_RIGHT;
				game.unitIsMoving = true;
			}
		}
		
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
