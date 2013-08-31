package com.github.lalaland.simpletowerdefense.enemies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.github.lalaland.simpletowerdefense.GameState;

public class EnemyManager {

    

    
    private DelayedRemovalArray<Enemy> currentEnemies = new DelayedRemovalArray<Enemy>();
    
    
    
    
    public EnemyManager() {
        
        
        
       
 
        
       
        
    }
    

    
    public void addGuys(int numberOfGuys)
    {
    	for (int i = 0; i < numberOfGuys;i++)
    	{
    		currentEnemies.add(new Enemy(GameState.getInstance().map.getPath(),-i));
    	}
    }
    
    public void render(SpriteBatch batch,ShapeRenderer sRender)
    {
        
        
        
        
        for (Enemy e: currentEnemies)
        {
        	e.render(batch,sRender);
            
 
        }

        
        
    }

	public void update(float delta) {
		currentEnemies.begin();
        for (int i = 0;i < currentEnemies.size; i++)
        {
            Enemy e = currentEnemies.get(i);
            
            e.update(delta);
            
            if (e.isDead())
            {
                currentEnemies.removeIndex(i);
               
            }
        }
        
        currentEnemies.end();
		
	}

	public Array<Enemy> getCurrentEnemies() {
		return currentEnemies;
	}

	
}
