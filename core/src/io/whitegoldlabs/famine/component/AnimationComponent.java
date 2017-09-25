package io.whitegoldlabs.famine.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ArrayMap;

public class AnimationComponent implements Component
{
	public ArrayMap<String, Animation<Sprite>> animations;
	
	public AnimationComponent()
	{
		animations = new ArrayMap<String, Animation<Sprite>>();
	}
}
