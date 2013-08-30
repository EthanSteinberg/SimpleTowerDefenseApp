package com.github.lalaland.simpletowerdefense.towers;

import com.badlogic.gdx.graphics.Texture;
import com.github.lalaland.simpletowerdefense.Resources;
import com.github.lalaland.simpletowerdefense.bullets.BulletType;
import com.github.lalaland.simpletowerdefense.bullets.SlowBullet;

public class SlowTower extends Tower {

	@Override
	public float getTargetRadius() {
		// TODO Auto-generated method stub
		return 3f;
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return Resources.slowTower;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public float getFireDelay() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public BulletType getBulletType() {
		// TODO Auto-generated method stub
		return new SlowBullet();
	}

}
