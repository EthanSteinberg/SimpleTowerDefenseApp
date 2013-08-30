package com.github.lalaland.simpletowerdefense.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.github.lalaland.simpletowerdefense.GameState;
import com.github.lalaland.simpletowerdefense.Resources;
import com.github.lalaland.simpletowerdefense.effects.PoisonEffect;
import com.github.lalaland.simpletowerdefense.effects.SlowEffect;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;

public class SlowBullet implements BulletType {

	@Override
	public void hitEnemy(Enemy e) {
		// TODO Auto-generated method stub
		GameState.getInstance().effects.addEffect(new SlowEffect(e));
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return Resources.slowBullet;
	}

}
