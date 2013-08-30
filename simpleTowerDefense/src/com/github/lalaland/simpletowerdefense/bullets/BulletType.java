package com.github.lalaland.simpletowerdefense.bullets;

import com.badlogic.gdx.graphics.Texture;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;

public interface BulletType {

	void hitEnemy(Enemy e);

	Texture getTexture();
}
