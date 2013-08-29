package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.Texture;

public class PoisionTower extends Tower {

	@Override
	public float getTargetRadius() {
		// TODO Auto-generated method stub
		return 3f;
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return Resources.poisonTower;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public float getFireDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

}
