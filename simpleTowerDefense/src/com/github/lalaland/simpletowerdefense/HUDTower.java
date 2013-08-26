package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class HUDTower {

	
	TowerType type;
	int x;
	int y;
	
	Rectangle thisBox;
	
	public HUDTower(TowerType type, int x, int y)
	{
		this.type = type;
		this.x = x;
		this.y = y;
		
		thisBox = new Rectangle(getX(),getY(),2,2);
	}
	
	
	float getY()
	{
		return 10.75f - y*2.5f;
	}
	
	float getX()
	{
		return 20.25f + x*2.5f;
	}
	
	
	public void render(SpriteBatch batch)
	{
		batch.draw(getPurchaseTexture(),getX(),getY(),2,2,0,1,1,0);
	}
	

	
	Texture getPurchaseTexture()
	{
		switch (type)
		{
		case BASIC_TOWER:
			return Resources.basicTowerPurchase;
		}

		throw new RuntimeException("Invalid purchase tower");
	}

	public void touchDown(float x, float y) {
		
		if (thisBox.contains(x, y))
		{
			System.out.println("I pressed a box");
		}
	}
}
