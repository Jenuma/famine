package io.whitegoldlabs.famine.system;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;

import io.whitegoldlabs.famine.Famine;
import io.whitegoldlabs.famine.component.PositionComponent;
import io.whitegoldlabs.famine.component.SpriteComponent;
import io.whitegoldlabs.famine.util.Mappers;

public class RenderSystem extends EntitySystem
{
	private ImmutableArray<Entity> drawableEntities;
	
	private final Famine game;
	
	public RenderSystem(final Famine game)
	{
		this.game = game;
	}
	
	@Override
	public void addedToEngine(Engine engine)
	{
		drawableEntities = engine.getEntitiesFor(Family.all
		(
				PositionComponent.class,
				SpriteComponent.class
		).get());
	}
	
	@Override
	public void update(float deltatime)
	{
		game.camera.update();
		game.batch.setProjectionMatrix(game.camera.combined);
		game.batch.begin();
		
		for(Entity entity : drawableEntities)
		{
			float x = Mappers.position.get(entity).x;
			float y = Mappers.position.get(entity).y;
			SpriteComponent spriteComponent = Mappers.sprite.get(entity);
			
			spriteComponent.sprite.setPosition(x, y);
			spriteComponent.sprite.draw(game.batch);
		}
		
		game.batch.end();
	}
}
