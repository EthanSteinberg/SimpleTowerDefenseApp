package com.github.lalaland.simpletowerdefense.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.github.lalaland.simpletowerdefense.Resources;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;

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
