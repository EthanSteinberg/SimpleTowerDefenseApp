package com.github.lalaland.simpletowerdefense.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.github.lalaland.simpletowerdefense.GameState;
import com.github.lalaland.simpletowerdefense.Resources;
import com.github.lalaland.simpletowerdefense.effects.AoeEffect;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;

public class AoeBullet implements BulletType {

	@Override
	public void hitEnemy(Enemy e) {
		GameState.getInstance().effects.addEffect(new AoeEffect(e));

	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return Resources.aoeBullet;
	}

}
