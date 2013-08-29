package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.Texture;

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
		return 0;
	}

}
