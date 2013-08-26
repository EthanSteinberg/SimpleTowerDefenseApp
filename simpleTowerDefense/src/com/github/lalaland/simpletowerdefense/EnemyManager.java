package com.github.lalaland.simpletowerdefense;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemyManager {

    TowerMap map;
    
    AStarSearch search;
    
    ResultNode pathToTarget;
    
    List<Enemy> currentEnemies = new ArrayList<Enemy>();
    
    OrthographicCamera camera;
    SpriteBatch batch;
    
    Texture dude;
    
    public EnemyManager(TowerMap map) {
        this.map = map;
        
        search = new AStarSearch(map);
        
        pathToTarget = search.getResult();
        
        currentEnemies.add(new Enemy(pathToTarget));
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, TowerMap.width*5/4, TowerMap.height);
        
        batch = new SpriteBatch();
        
        dude = new Texture(Gdx.files.internal("dude.png"));
        
    }
    
    void render(float time)
    {
        
        Iterator<Enemy> it = currentEnemies.iterator();
        while (it.hasNext())
        {
            Enemy e = it.next();
            
            e.update(time);
            
            if (e.isOffScreen())
            {
                it.remove();
                GameState.getInstance().health-=1;
            }
        }
        
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (Enemy e: currentEnemies)
        {
            batch.draw(dude,e.getX(),e.getY(),1,1,0,1,1,0);
 
        }
        batch.end();
        
        
        
    }
}
