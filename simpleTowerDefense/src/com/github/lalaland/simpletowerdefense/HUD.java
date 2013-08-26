package com.github.lalaland.simpletowerdefense;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HUD {

    OrthographicCamera camera = new OrthographicCamera();
    
    SpriteBatch batch = new SpriteBatch();
    
    Texture lifeCounter;
    Texture moneyCounter;
    
    OrthographicCamera textCamera= new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    
    
    ArrayList<HUDTower> hudTowers = new ArrayList<HUDTower>();
    
    BitmapFont f = new BitmapFont(Gdx.files.internal("mono35ascii.fnt"),false);
    public HUD()
    {
        camera.setToOrtho(false,25,15);
        textCamera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        lifeCounter = new Texture(Gdx.files.internal("lifeCounter.png"));
        moneyCounter = new Texture(Gdx.files.internal("moneyCounter.png"));
        
        hudTowers.add(new HUDTower(TowerType.BASIC_TOWER, 0, 0));
        hudTowers.add(new HUDTower(TowerType.BASIC_TOWER, 1, 1 ));
        
    }
    
    public void touchDown(float x, float y)
    {
    	for (HUDTower tower: hudTowers)
    		tower.touchDown(x,y);
    }
    
    public void render()
    {
        camera.update();
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(lifeCounter, 20, 14, 5, 1, 0, 1, 1, 0);
       
        batch.draw(moneyCounter,20,13,5,1,0,1,1,0);
        
        for (HUDTower tower : hudTowers)
        	tower.render(batch);
        
        batch.end();
        
        
        textCamera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        textCamera.update();      
        batch.setProjectionMatrix(textCamera.combined);
        batch.begin();
      
        f.setColor(0,0,1,1);
        f.draw(batch, GameState.getInstance().health + "" ,Gdx.graphics.getWidth() * 19.125f/20, Gdx.graphics.getHeight() * 14.75f/15);
        f.draw(batch, GameState.getInstance().money + "" ,Gdx.graphics.getWidth() * 19.125f/20, Gdx.graphics.getHeight() * 13.75f/15);
        
        
        batch.end();
        
        
    }
}
