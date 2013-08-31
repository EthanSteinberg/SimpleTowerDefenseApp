package com.github.lalaland.simpletowerdefense;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.StringBuilder;
import com.github.lalaland.simpletowerdefense.towers.TowerType;

public class HUD {

	String currentMessage;
	boolean showingMessage;
	
    OrthographicCamera camera = new OrthographicCamera();
    
    SpriteBatch batch = new SpriteBatch();
    
    Texture lifeCounter;
    Texture moneyCounter;
    Texture nextWaveButton;
    
    OrthographicCamera textCamera= new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    
    
    Rectangle nextWaveButtonRect = new Rectangle(20,12,5,1);
    
    Array<HUDTower> hudTowers = new Array<HUDTower>();
    
    BitmapFont f = new BitmapFont(Gdx.files.internal("HUD/mono35ascii.fnt"),false);
    public HUD()
    {
        camera.setToOrtho(false,25,15);
        textCamera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        lifeCounter = new Texture(Gdx.files.internal("HUD/lifeCounter.png"));
        moneyCounter = new Texture(Gdx.files.internal("HUD/moneyCounter.png"));
        nextWaveButton = new Texture(Gdx.files.internal("HUD/nextWaveButton.png"));
        
        hudTowers.add(new HUDTower(TowerType.BASIC_TOWER, 0, 0));
        hudTowers.add(new HUDTower(TowerType.AOE_TOWER, 1, 0 ));
        hudTowers.add(new HUDTower(TowerType.SLOW_TOWER, 0, 1 ));
        hudTowers.add(new HUDTower(TowerType.POISON_TOWER, 1, 1 ));
        
        
    }
    
    public void showMessage(String message)
    {
    	currentMessage = message;
    	showingMessage = true;
    }
    
    public void hideMessage()
    {
    	showingMessage = false;
    }
    
    public boolean touchDown(float x, float y)
    {
    	if (showingMessage)
    	{
    		hideMessage();
    		return true;
    	}
    	else if (nextWaveButtonRect.contains(x, y))
    	{
    		GameState.getInstance().waves.executeWave();
    		return true;
    	}
    	
    	for (HUDTower tower: hudTowers)
    	{
    		if(tower.touchDown(x,y))
    			return true;
    		
    	}
    	
    	return false;
    }
    

    StringBuilder temp = new StringBuilder();
    
    public void render()
    {
        camera.update();
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(lifeCounter, 20, 14, 5, 1, 0, 1, 1, 0);
       
        batch.draw(moneyCounter,20,13,5,1,0,1,1,0);
        batch.draw(nextWaveButton,20,12,5,1,0,1,1,0);
        
        for (HUDTower tower : hudTowers)
        	tower.render(batch);
        
        
        if (showingMessage)
        	batch.draw(Resources.messageBox,7,6,6,3,0,0,384,192,false,false);
        batch.end();
        
        
        textCamera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        textCamera.update();      
        batch.setProjectionMatrix(textCamera.combined);
        batch.begin();
      
        f.setColor(0,0,1,1);
        
        temp.setLength(0);
        temp.append(GameState.getInstance().health);
        f.draw(batch, temp ,Gdx.graphics.getWidth() * 24f/25, Gdx.graphics.getHeight() * 14.75f/15);
        
        
        temp.setLength(0);
        temp.append(GameState.getInstance().money);
        f.draw(batch, temp ,Gdx.graphics.getWidth() * 24f/25, Gdx.graphics.getHeight() * 13.75f/15);
        
        if (showingMessage)
        {
        	f.setColor(0,0,0,1);
        	f.draw(batch, currentMessage ,Gdx.graphics.getWidth() * 8f/25, Gdx.graphics.getHeight() * 7.5f/15);
            
        }
        
        batch.end();
        
        
    }
}
