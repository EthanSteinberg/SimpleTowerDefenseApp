package com.github.lalaland.simpletowerdefense.enemies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.lalaland.simpletowerdefense.GameState;

public class EnemyManager {

    
    AStarSearch search;
    
    ResultNode pathToTarget;
    
    private List<Enemy> currentEnemies = new ArrayList<Enemy>();
    
    
    
    
    public EnemyManager() {
        
        search = new AStarSearch(GameState.getInstance().map);
        
        pathToTarget = search.getResult();
        
        currentEnemies.add(new Enemy(pathToTarget));
        
       
 
        
       
        
    }
    
    public void addGuy()
    {
    	currentEnemies.add(new Enemy(pathToTarget));
    }
    
    public void render(SpriteBatch batch)
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

	public List<Enemy> getCurrentEnemies() {
		return currentEnemies;
	}

	public void setCurrentEnemies(List<Enemy> currentEnemies) {
		this.currentEnemies = currentEnemies;
	}
}
