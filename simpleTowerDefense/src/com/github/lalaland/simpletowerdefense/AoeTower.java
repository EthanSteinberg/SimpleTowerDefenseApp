package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.Texture;

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
		return 0;
	}

	@Override
	public BulletType getBulletType() {
		// TODO Auto-generated method stub
		return new AoeBullet();
	}

}
