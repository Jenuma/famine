package io.whitegoldlabs.famine.system;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;

import io.whitegoldlabs.famine.Famine;
import io.whitegoldlabs.famine.component.AnimationComponent;
import io.whitegoldlabs.famine.component.SpriteComponent;
import io.whitegoldlabs.famine.component.StateComponent;
import io.whitegoldlabs.famine.util.Mappers;

public class AnimationSystem extends EntitySystem
{
	private ImmutableArray<Entity> entities;
	
	private final Famine game;
	
	public AnimationSystem(final Famine game)
	{
		this.game = game;
	}
	
	@Override
	public void addedToEngine(Engine engine)
	{
		entities = game.engine.getEntitiesFor(Family.all
		(
				AnimationComponent.class,
				SpriteComponent.class,
				StateComponent.class
		).get());
	}
	
	@Override
	public void update(float deltaTime)
	{
		for(Entity entity : entities)
		{
			AnimationComponent animationComponent = Mappers.animation.get(entity);
			SpriteComponent currentSprite = Mappers.sprite.get(entity);
			StateComponent stateComponent = Mappers.state.get(entity);
			
			if(animationComponent.animations.containsKey(stateComponent.state.toString()))
			{
				currentSprite.sprite = animationComponent.animations.get(stateComponent.state.toString())
						.getKeyFrame(stateComponent.time, true);
			}
			
			if(stateComponent.state.toString().equals("MOVING_RIGHT"))
			{
				currentSprite.sprite.setFlip(true, false);
			}
			else if(stateComponent.state.toString().equals("MOVING_LEFT"))
			{
				currentSprite.sprite.setFlip(false, false);
			}
			
			stateComponent.time += deltaTime;
		}
	}
}
