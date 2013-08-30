package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BasicTower extends Tower{

	
	public BasicTower()
	{
	}
	

	


	@Override
	public float getTargetRadius() {
		// TODO Auto-generated method stub
		return 3f;
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return Resources.basicTower;
	}





	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 10;
	}





	@Override
	public float getFireDelay() {
		// TODO Auto-generated method stub
		return 1;
	}





	@Override
	public BulletType getBulletType() {
		// TODO Auto-generated method stub
		return new BasicBullet();
	}


	
}
