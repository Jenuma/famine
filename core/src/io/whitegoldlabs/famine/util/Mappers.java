package io.whitegoldlabs.famine.util;

import com.badlogic.ashley.core.ComponentMapper;

import io.whitegoldlabs.famine.component.AnimationComponent;
import io.whitegoldlabs.famine.component.PositionComponent;
import io.whitegoldlabs.famine.component.SpriteComponent;
import io.whitegoldlabs.famine.component.StateComponent;

public class Mappers
{
	public static final ComponentMapper<AnimationComponent> animation = ComponentMapper.getFor(AnimationComponent.class);
	public static final ComponentMapper<PositionComponent> position = ComponentMapper.getFor(PositionComponent.class);
	public static final ComponentMapper<SpriteComponent> sprite = ComponentMapper.getFor(SpriteComponent.class);
	public static final ComponentMapper<StateComponent> state = ComponentMapper.getFor(StateComponent.class);
}
