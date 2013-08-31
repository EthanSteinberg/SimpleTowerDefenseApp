package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.github.lalaland.simpletowerdefense.towers.TowerType;

public class HUDTower {

	
	TowerType type;
	int x;
	int y;
	boolean pressed = false;
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
		return 9.75f - y*2.5f;
	}
	
	float getX()
	{
		return 20.25f + x*2.5f;
	}
	
	
	public void render(SpriteBatch batch)
	{
		if (!pressed)
			batch.draw(getPurchaseTexture(),getX(),getY(),2,2,0,1,1,0);
		else
			batch.draw(getPressedPurchaseTexture(),getX(),getY(),2,2,0,1,1,0);
	}
	

	

	int getCost()
	{
		switch (type)
		{
		case BASIC_TOWER:
			return 10;
		case AOE_TOWER:
			return 15;
		case POISON_TOWER:
			return 30;
		case SLOW_TOWER:
			return 20;
		
		}
		throw new RuntimeException("Invalid purchase tower");
	}
	
	Texture getPressedPurchaseTexture() {
		switch (type)
		{
		case BASIC_TOWER:
			return Resources.basicTowerPressedPurchase;
		case AOE_TOWER:
			return Resources.aoeTowerPressedPurchase;
		case POISON_TOWER:
			return Resources.poisonTowerPressedPurchase;
		case SLOW_TOWER:
			return Resources.slowTowerPressedPurchase;
		}

		throw new RuntimeException("Invalid purchase tower");
	}


	Texture getPurchaseTexture()
	{
		switch (type)
		{
		case BASIC_TOWER:
			return Resources.basicTowerPurchase;
		case AOE_TOWER:
			return Resources.aoeTowerPurchase;
		case POISON_TOWER:
			return Resources.poisonTowerPurchase;
		case SLOW_TOWER:
			return Resources.slowTowerPurchase;
		}

		throw new RuntimeException("Invalid purchase tower");
	}

	public boolean touchDown(float x, float y) {
		
		if (thisBox.contains(x, y))
		{
			if (GameState.getInstance().money < getCost())
			{
				GameState.getInstance().hud.showMessage("Not Enough Gold");
			}
			
			else
			{
				GameState.getInstance().startCreatingTower(this, type);
				
				pressed= true;
			}
			
			return true;
		}
		return false;
	}
}
