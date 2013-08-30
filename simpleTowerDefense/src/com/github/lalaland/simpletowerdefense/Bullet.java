package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {

	float x;
	float y;
	
	final static float vel = 5;
	Enemy target;
	final static float tolerance = .1f;
	boolean dead = false;
	
	BulletType type;
	
	
	public Bullet(float x, float y, Enemy target, BulletType type)
	{
		this.x = x;
		this.y = y;
		this.target=  target;
		this.type = type;
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
		Rectangle targetRect = new Rectangle(target.getX(),target.getY(),1,1);
		return targetRect.contains(x, y);
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
