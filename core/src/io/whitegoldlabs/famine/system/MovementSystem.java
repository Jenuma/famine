package io.whitegoldlabs.famine.system;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;

import io.whitegoldlabs.famine.Famine;
import io.whitegoldlabs.famine.component.PositionComponent;
import io.whitegoldlabs.famine.component.StateComponent;
import io.whitegoldlabs.famine.component.StateComponent.State;
import io.whitegoldlabs.famine.util.Mappers;

public class MovementSystem extends EntitySystem
{
	private ImmutableArray<Entity> entities;
	
	private final Famine game;
	
	public MovementSystem(final Famine game)
	{
		this.game = game;
	}
	
	@Override
	public void addedToEngine(Engine engine)
	{
		entities = engine.getEntitiesFor(Family.all
		(
				PositionComponent.class,
				StateComponent.class
		).get());
	}
	
	@Override
	public void update(float deltaTime)
	{
		for(Entity entity : entities)
		{
			PositionComponent positionComponent = Mappers.position.get(entity);
			StateComponent stateComponent = Mappers.state.get(entity);
			
			if(stateComponent.state.toString().equals("MOVING_UP"))
			{
				positionComponent.y += 2;
				game.movementAmount += 2;
			}
			else if(stateComponent.state.toString().equals("MOVING_DOWN"))
			{
				positionComponent.y -= 2;
				game.movementAmount += 2;
			}
			else if(stateComponent.state.toString().equals("MOVING_LEFT"))
			{
				positionComponent.x -= 2;
				game.movementAmount += 2;
			}
			else if(stateComponent.state.toString().equals("MOVING_RIGHT"))
			{
				positionComponent.x += 2;
				game.movementAmount += 2;
			}
			
			if(game.movementAmount == 32)
			{
				stateComponent.state = State.STILL;
				game.movementAmount = 0;
				game.unitIsMoving = false;
			}
		}
	}
}
