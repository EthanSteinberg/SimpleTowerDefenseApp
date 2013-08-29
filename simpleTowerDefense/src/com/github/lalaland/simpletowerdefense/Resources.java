package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Resources {

	
	public static void init()
	{
		basicTower = new Texture(Gdx.files.internal("tower/basicTower.png"));
		basicTowerPurchase = new Texture(Gdx.files.internal("tower/basicTowerPurchase.png"));
		basicTowerPressedPurchase = new Texture(Gdx.files.internal("tower/basicTowerPurchasePressed.png"));
		
		aoeTower = new Texture(Gdx.files.internal("tower/aoeTower.png"));
		aoeTowerPurchase = new Texture(Gdx.files.internal("tower/aoeTowerPurchase.png"));
		aoeTowerPressedPurchase = new Texture(Gdx.files.internal("tower/aoeTowerPurchasePressed.png"));

		slowTower = new Texture(Gdx.files.internal("tower/slowTower.png"));
		slowTowerPurchase = new Texture(Gdx.files.internal("tower/slowTowerPurchase.png"));
		slowTowerPressedPurchase = new Texture(Gdx.files.internal("tower/slowTowerPurchasePressed.png"));
		
		poisonTower = new Texture(Gdx.files.internal("tower/poisonTower.png"));
		poisonTowerPurchase = new Texture(Gdx.files.internal("tower/poisonTowerPurchase.png"));
		poisonTowerPressedPurchase = new Texture(Gdx.files.internal("tower/poisonTowerPurchasePressed.png"));
		
		
		bullet = new Texture(Gdx.files.internal("bullet.png"));
		dude = new Texture(Gdx.files.internal("dude.png"));
		messageBox = new Texture(Gdx.files.internal("messageBox.png"));
	}
	
	
	public static Texture basicTower;
	public static Texture basicTowerPurchase;
	public static Texture basicTowerPressedPurchase;
	
	public static Texture aoeTower;
	public static Texture aoeTowerPurchase;
	public static Texture aoeTowerPressedPurchase;
	
	public static Texture slowTower;
	public static Texture slowTowerPurchase;
	public static Texture slowTowerPressedPurchase;
	
	public static Texture poisonTower;
	public static Texture poisonTowerPurchase;
	public static Texture poisonTowerPressedPurchase;
	
	
	public static Texture bullet;
	public static Texture dude;
	public static Texture messageBox;
}
