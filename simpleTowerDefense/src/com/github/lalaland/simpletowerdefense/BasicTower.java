package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BasicTower implements Tower{

	
	int x;
	int y;
	
	public BasicTower(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		
		batch.draw(Resources.basicTower,x,y,1,1,0,1,1,0);
		
	}

	
}
