package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState {

    
    
    int health = 10;
    int money = 100;
     Tower towerToCreate = null;
     boolean creatingTower;
	 HUDTower pressedHUD;
	
	public TowerMap map;
	
	public EnemyManager enemies;
	public BulletManager bullets;
	public TowerManager towers ;
	public GameClock clock;
	
	public HUD hud;
	
	boolean ready = false;
    
	
	public void startCreatingTower(HUDTower pressedHUD, TowerType type)
	{
		creatingTower = true;
		this.pressedHUD = pressedHUD;
		towerToCreate = Tower.getTower(type);
	}
	
	public void cancelCreatingTower()
	{
		pressedHUD.pressed = false;
		pressedHUD = null;
		towerToCreate = null;
		creatingTower = false;
	}
	
	public void finishCreatingTower()
	{
		money -= towerToCreate.getCost();
		map.setTower(towerToCreate);
		
		towers.addTower(towerToCreate);
		
		
		pressedHUD.pressed = false;
		pressedHUD = null;
		towerToCreate = null;
		creatingTower = false;
	}
	

	
	public void towerCreationTouch()
	{
		if (map.validPlaceForTower( towerToCreate.x, towerToCreate.y))
    	{
        	
        	finishCreatingTower();
        }
    	else
    	{
    		cancelCreatingTower();
    		
    	}
	}
	
   
    
    private final static GameState state = new GameState();
    
    public void init(TowerMap map)
    {
    	this.map = map;
        enemies = new EnemyManager();
    	bullets = new BulletManager();
    	towers = new TowerManager();
    	clock = new GameClock();
    	hud = new HUD();
    	
    	ready = true;
    }

    public boolean isReady()
    {
    	return ready;
    }
    public static GameState getInstance()
    {      
        return state;
    }

	public void update(float delta) {
		clock.tick(delta);
		
		enemies.update(delta);
		towers.update(delta);
		bullets.update(delta);
		
		
	}
	
	public void render(SpriteBatch batch)
	{
		enemies.render(batch);
		towers.render(batch);
		bullets.render(batch);
		
	}

	public void touchDown(float x, float y) {
		
		if (hud.touchDown(x, y))
			return;
		
		if (creatingTower)
        {
			towerCreationTouch();
        }
		
		
	}

	public void reduceHealth() {
		health-=1;
		
		if (health <0)
			hud.showMessage("You Have Lost");
		
	}
}
