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
		
		
		basicBullet = new Texture(Gdx.files.internal("bullet/basicBullet.png"));
		poisonBullet = new Texture(Gdx.files.internal("bullet/poisonBullet.png"));
		slowBullet = new Texture(Gdx.files.internal("bullet/slowBullet.png"));
		aoeBullet = new Texture(Gdx.files.internal("bullet/aoeBullet2.png"));
		
		explosion = new Texture(Gdx.files.internal("bullet/explosion.png"));
		
		regularEnemy = new Texture(Gdx.files.internal("enemy/regularEnemy.png"));
		regularEnemySlow = new Texture(Gdx.files.internal("enemy/regularEnemySlow.png"));
		regularEnemyPoison = new Texture(Gdx.files.internal("enemy/regularEnemyPoison.png"));
		regularEnemyPoisonSlow = new Texture(Gdx.files.internal("enemy/regularEnemyPoisonSlow.png"));
		
		
		messageBox = new Texture(Gdx.files.internal("HUD/messageBox.png"));
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
	
	
	public static Texture basicBullet;
	public static Texture poisonBullet;
	public static Texture slowBullet;
	public static Texture aoeBullet;
	
	public static Texture explosion;
	
	public static Texture regularEnemy;
	public static Texture regularEnemySlow;
	public static Texture regularEnemyPoison;
	public static Texture regularEnemyPoisonSlow;
	public static Texture messageBox;
}
