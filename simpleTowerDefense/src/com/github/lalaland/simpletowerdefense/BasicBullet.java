package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.Texture;

public class BasicBullet implements BulletType {

	@Override
	public void hitEnemy(Enemy e) {
		e.damage(25);

	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return Resources.basicBullet;
	}

}
