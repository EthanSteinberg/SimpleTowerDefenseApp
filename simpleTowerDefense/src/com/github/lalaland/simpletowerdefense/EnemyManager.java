package com.github.lalaland.simpletowerdefense;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemyManager {

    
    AStarSearch search;
    
    ResultNode pathToTarget;
    
    List<Enemy> currentEnemies = new ArrayList<Enemy>();
    
    
    
    
    public EnemyManager() {
        
        search = new AStarSearch(GameState.getInstance().map);
        
        pathToTarget = search.getResult();
        
        currentEnemies.add(new Enemy(pathToTarget));
        
       
 
        
       
        
    }
    
    void addGuy()
    {
    	currentEnemies.add(new Enemy(pathToTarget));
    }
    
    void render(SpriteBatch batch)
    {
        
        
        
        
        for (Enemy e: currentEnemies)
        {
        	e.render(batch);
            
 
        }

        
        
    }

	public void update(float delta) {
		Iterator<Enemy> it = currentEnemies.iterator();
        while (it.hasNext())
        {
            Enemy e = it.next();
            
            e.update(delta);
            
            if (e.isDead())
            {
                it.remove();
               
            }
        }
		
	}
}
