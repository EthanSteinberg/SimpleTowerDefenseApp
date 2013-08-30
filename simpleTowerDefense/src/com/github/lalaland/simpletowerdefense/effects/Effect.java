package com.github.lalaland.simpletowerdefense.effects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Effect {

	public abstract void update(float delta);
	public abstract boolean isDead();
	
	public void render(SpriteBatch batch)
	{
		
	}
}
