package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Resources {

	public static void init()
	{
		basicTower = new Texture(Gdx.files.internal("basicTower.png"));
		basicTowerPurchase = new Texture(Gdx.files.internal("basicTowerPurchase.png"));
	}
	
	
	public static Texture basicTower;
	public static Texture basicTowerPurchase;
}
