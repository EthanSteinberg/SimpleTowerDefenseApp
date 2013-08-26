package com.github.lalaland.simpletowerdefense;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class MapRenderer implements Disposable{

    
    TowerMap map;
    
    OrthographicCamera camera;
    SpriteBatch batch;
    
    
    
    
    Texture green;
    Texture tan;
    Texture yellow;
    Texture red;
    
    Texture startStar;
    Texture stopStar;
    
    Map<Integer,Texture> tileMap = new HashMap<Integer, Texture>();
    
    
    public MapRenderer() {
        
        
        green = new Texture(Gdx.files.internal("green.png"));
        tan = new Texture(Gdx.files.internal("tan.png"));
        yellow = new Texture(Gdx.files.internal("yellow.png"));
        red = new Texture(Gdx.files.internal("red.png"));
        
        startStar = new Texture(Gdx.files.internal("startStar.png"));
        stopStar = new Texture(Gdx.files.internal("stopStar.png"));
        
        tileMap.put(0, green);
        tileMap.put(1, tan);
        tileMap.put(2,yellow);
        tileMap.put(3, red);
        
       
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false,TowerMap.width*5/4,TowerMap.height);
        
        
        batch = new SpriteBatch();
        
    }
    
    public void setMap(TowerMap map)
    {
        this.map = map;
    }
    
    
    public OrthographicCamera getCamera()
    {
        return camera;
    }
    
    public void render()
    {
        camera.update();
        
        batch.setProjectionMatrix(camera.combined);
        
        batch.begin();
       
        
        
        for (int y = 0;y<TowerMap.height; y++)
            for (int x = 0; x < TowerMap.width; x++)
            {
                int color = map.getPos(x, y);
                Texture te = tileMap.get(color);
                
                batch.draw(te, x,y,1,1,0,1,1,0);

            }
        
        batch.draw(startStar, map.startX, map.startY, 1,1,0,1,1,0);
        batch.draw(stopStar, map.stopX, map.stopY, 1,1,0,1,1,0);
        
        batch.end();
        
    }
    
    
    
   

    @Override
    public void dispose() {
        
        
        green.dispose();
        tan.dispose();
        
        batch.dispose();
        
    }
    
    
    
    
}