package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.Texture;

public interface BulletType {

	void hitEnemy(Enemy e);

	Texture getTexture();
}
