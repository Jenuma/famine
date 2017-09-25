package io.whitegoldlabs.famine.component;

import com.badlogic.ashley.core.Component;

public class StateComponent implements Component
{
	public enum State
	{
		STILL,
		MOVING_UP,
		MOVING_DOWN,
		MOVING_LEFT,
		MOVING_RIGHT
	}
	
	public State state;
	public float time;
	
	public StateComponent()
	{
		state = State.STILL;
		time = 0;
	}
}
