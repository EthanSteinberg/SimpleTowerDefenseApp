package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.Texture;

public class PoisonBullet implements BulletType {

	@Override
	public void hitEnemy(Enemy e) {
		

	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return Resources.poisonBullet;
	}

}
