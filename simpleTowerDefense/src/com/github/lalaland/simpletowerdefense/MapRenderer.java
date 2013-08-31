package com.github.lalaland.simpletowerdefense;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;
import com.github.lalaland.simpletowerdefense.towers.Tower;

public class MapRenderer implements Disposable{

    

    
    OrthographicCamera camera;
    SpriteBatch batch;
    ShapeRenderer sRender;
    
    
    Texture green;
    Texture tan;
    Texture yellow;
    Texture red;
    
    Texture startStar;
    Texture stopStar;
    
    Map<Integer,Texture> tileMap = new HashMap<Integer, Texture>();
    
    
    public MapRenderer() {
        
        
        green = new Texture(Gdx.files.internal("map/green.png"));
        tan = new Texture(Gdx.files.internal("map/tan.png"));
        yellow = new Texture(Gdx.files.internal("map/yellow.png"));
        red = new Texture(Gdx.files.internal("map/red.png"));
        
        startStar = new Texture(Gdx.files.internal("map/startStar.png"));
        stopStar = new Texture(Gdx.files.internal("map/stopStar.png"));
        
        tileMap.put(0, green);
        tileMap.put(1, tan);
        tileMap.put(2,yellow);
        tileMap.put(3, red);
        
       
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false,TowerMap.width*5/4,TowerMap.height);
        
        
        batch = new SpriteBatch();
        sRender = new ShapeRenderer();
        
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
                int color = GameState.getInstance().map.getPos(x, y);
                
                Texture te = tileMap.get(color);
                
                batch.draw(te, x,y,1,1,0,1,1,0);
                	
                

                
                

            }
        
        for (int y = 0;y<TowerMap.height; y++)
            for (int x = 0; x < TowerMap.width; x++)
            {
            	Tower t = GameState.getInstance().map.getTower(x, y);
                if (t!= null)
                {
                	t.render(batch);
               
                }
            }
        
        batch.draw(startStar, GameState.getInstance().map.startX, GameState.getInstance().map.startY, 1,1,0,1,1,0);
        batch.draw(stopStar, GameState.getInstance().map.stopX, GameState.getInstance().map.stopY, 1,1,0,1,1,0);
        
        batch.end();
        
        
        sRender.setProjectionMatrix(camera.combined);
        
        for (int y = 0;y<TowerMap.height; y++)
            for (int x = 0; x < TowerMap.width; x++)
            {
            	Tower t = GameState.getInstance().map.getTower(x, y);
                if (t!= null)
                {
                
                	t.renderAreaOfAttack(sRender);
                }
            }
        
        
        
    }
    
    
    
   

    @Override
    public void dispose() {
        
        
        green.dispose();
        tan.dispose();
        
        batch.dispose();
        
    }
    
    
    
    
}
