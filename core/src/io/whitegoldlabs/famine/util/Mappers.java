package io.whitegoldlabs.famine.util;

import com.badlogic.ashley.core.ComponentMapper;

import io.whitegoldlabs.famine.component.PositionComponent;
import io.whitegoldlabs.famine.component.SpriteComponent;

public class Mappers
{
	public static final ComponentMapper<PositionComponent> position = ComponentMapper.getFor(PositionComponent.class);
	public static final ComponentMapper<SpriteComponent> sprite = ComponentMapper.getFor(SpriteComponent.class);
}
