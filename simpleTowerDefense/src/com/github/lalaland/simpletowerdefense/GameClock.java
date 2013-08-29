package com.github.lalaland.simpletowerdefense;

public class GameClock {

	float currentTime = 0;
	
	public GameClock()
	{
		
	}
	
	public void reset()
	{
		currentTime  = 0;
	}
	
	public float getTime()
	{
		return currentTime;
	}
	
	public void tick(float delta)
	{
		currentTime += delta;
	}
	
	
	
}
