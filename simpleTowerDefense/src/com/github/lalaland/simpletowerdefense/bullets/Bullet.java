package com.github.lalaland.simpletowerdefense.bullets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;

public class Bullet {

	float x;
	float y;
	Enemy target;
	boolean dead = false;
	BulletType type;
	
	final static float vel = 5;
	
	final static float tolerance = .1f;
	
	final static Rectangle tempRect = new Rectangle(); // WARNING, NOT THREAD SAFE
	
	
	
	
	public void set(float x, float y, Enemy target, BulletType type)
	{
		this.x = x;
		this.y = y;
		this.target=  target;
		this.type = type;
		this.dead = false;
	}
	
	public Bullet() {
	}

	public void update(float time)
	{
		if (dead || target.isDead())
		{
			dead = true;
			return;
		}
			
		
		float xDir = target.getX()+.5f - x;
		float yDir = target.getY()+.5f - y;
		
		float magnitude = (float) Math.sqrt(xDir * xDir + yDir * yDir);
		float velX = vel * xDir/magnitude;
		float velY = vel * yDir/magnitude;
		

		
		x+= velX*time;
		y+= velY*time;
		
		if (hasHitTarget())
		{
			dead = true;
			type.hitEnemy(target);
		}
		
		
	}
	
	boolean hasHitTarget()
	{
		tempRect.set(target.getX(),target.getY(),1,1);
		return tempRect.contains(x, y);
	}
	
	float getAngle()
	{
		float xDir = target.getX()+.5f - x;
		float yDir = target.getY()+.5f - y;
		return (float) Math.atan2(yDir, xDir);
	}
	
	public void render(SpriteBatch batch)
	{
		if (dead)
			return; 
		
		batch.draw(type.getTexture(), x-.25f, y-.25f, .25f, .25f, .5f, .5f, 1, 1, getAngle() * 180/(float) Math.PI, 0, 0, 32,32, false, false);
	}
	
	boolean isDead()
	{
		return dead;
	}
}
