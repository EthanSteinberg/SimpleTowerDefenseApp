package com.github.lalaland.simpletowerdefense.towers;

import com.badlogic.gdx.graphics.Texture;
import com.github.lalaland.simpletowerdefense.Resources;
import com.github.lalaland.simpletowerdefense.bullets.AoeBullet;
import com.github.lalaland.simpletowerdefense.bullets.BulletType;

public class AoeTower extends Tower {

	@Override
	public float getTargetRadius() {
		// TODO Auto-generated method stub
		return 3f;
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return Resources.aoeTower;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 15;
	}

	@Override
	public float getFireDelay() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public BulletType getBulletType() {
		// TODO Auto-generated method stub
		return new AoeBullet();
	}

}
