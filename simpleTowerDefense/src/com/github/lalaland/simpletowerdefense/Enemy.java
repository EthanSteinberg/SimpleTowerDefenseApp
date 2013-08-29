package com.github.lalaland.simpletowerdefense;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Enemy {
    ResultNode lastPosition;
    float position;
	public int positionsGoneThrough;
	
	private int health = 100;
	
	
	boolean dead;
	
	public boolean isDead()
	{
		return dead;
	}
    
    public Enemy(ResultNode startingPosition) {
        lastPosition = startingPosition;
        position = 0;
        positionsGoneThrough = 0;
    }
    
    void update(float time)
    {
    	
    	if (dead)
    		return;
    	
        position+= time*3;
        
        if (position > 1)
        {
            lastPosition = lastPosition.next;
            position-=1;
            positionsGoneThrough++;
        }
        
        if (isOffScreen())
        {
        	 GameState.getInstance().reduceHealth();
        	 dead = true;
        }
        
        
    }
    
   

	float getX()
    {
        return lastPosition.x + (lastPosition.next.x - lastPosition.x) * position;
    }
    
    float getY()
    {
        return lastPosition.y + (lastPosition.next.y - lastPosition.y) * position;
    }
    
    private boolean isOffScreen()
    {
        return lastPosition.next == null;
    }

	public float getTotalDistance() {
		// TODO Auto-generated method stub
		return positionsGoneThrough + position;
	}

	public void render(SpriteBatch batch) {
		
		if (dead)
			return;
		
		batch.draw(Resources.dude,getX(),getY(),1,1,0,1,1,0);
		
		
		ShapeRenderer render = new ShapeRenderer();
		render.setProjectionMatrix(batch.getProjectionMatrix());
		
		float greenWidth = health/100.0f;
		
		render.begin(ShapeType.Filled);
		render.setColor(Color.BLACK);
		render.rect(getX(), getY()-.15f, 1, .1f);
		render.setColor(Color.RED);
		render.rect(getX()+.05f, getY()-.125f, .9f, .05f);
		render.setColor(Color.GREEN);
		render.rect(getX()+.05f, getY()-.125f, .9f * greenWidth, .05f);
		
		render.end();
		
	}

	public void damage(int i) {
		health -= i;
		if (health <= 0)
		{
			GameState.getInstance().money+=10;
			dead = true;
		}
			
		
	}
    
	
    
}
