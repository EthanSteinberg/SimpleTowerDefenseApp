package com.github.lalaland.simpletowerdefense;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public abstract class Tower {

	int x;
	int y;
	float lastFire = GameState.getInstance().clock.getTime();
	
	
	
	
	public void render(SpriteBatch batch)
	{
		batch.draw(getTexture(),getX(),getY(),1,1,0,1,1,0);
		
	
	}
	
	public void renderAreaOfAttack(ShapeRenderer sRender)
	{		
		Gdx.gl.glEnable(GL10.GL_BLEND);
	    Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		
		sRender.begin(ShapeType.Filled);
		sRender.setColor(0,0,.5f,.5f);
		sRender.circle(getX()+.5f, getY()+.5f, getTargetRadius(),30);
		sRender.end();
		
		sRender.begin(ShapeType.Line);
		sRender.setColor(0,0,0,1);
		sRender.circle(getX()+.5f, getY()+.5f, getTargetRadius(),30);
		sRender.end();
		
		Gdx.gl.glDisable(GL10.GL_BLEND);
	}
	
	public void renderBadPlacement(ShapeRenderer sRender)
	{
		Gdx.gl.glEnable(GL10.GL_BLEND);
	    Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		
		sRender.begin(ShapeType.Filled);
		sRender.setColor(.5f,0,0,.5f);
		sRender.circle(getX()+.5f, getY()+.5f, getTargetRadius(),30);
		sRender.end();
		
		sRender.begin(ShapeType.Line);
		sRender.setColor(0,0,0,1);
		sRender.circle(getX()+.5f, getY()+.5f, getTargetRadius(),30);
		sRender.end();
		
		sRender.begin(ShapeType.Line);
		sRender.setColor(0,0,0,1);
		sRender.rect(getX(), getY(), 1, 1);
		sRender.line(getX(), getY(), getX() +1, getY()+1);
		sRender.line(getX()+1, getY(), getX(), getY()+1);
		sRender.end();
		
		Gdx.gl.glDisable(GL10.GL_BLEND);
	}
	
	abstract public float getTargetRadius();
	abstract public Texture getTexture();
	abstract public int getCost();
	abstract public float getFireDelay();
	abstract public BulletType getBulletType();
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void update()
	{
		if (lastFire + getFireDelay() < GameState.getInstance().clock.getTime())
			attemptToShoot();
		
		
	}
	
	private void attemptToShoot()
	{
		Enemy target = getFarthestEnemy();
		
		if (target != null)
		{
			GameState.getInstance().bullets.fireBullet(x, y, target,getBulletType());
			lastFire = GameState.getInstance().clock.getTime();
		}
	}
	
	 private Enemy getFarthestEnemy() {
			// TODO Auto-generated method stub
			
			float targetRadiusSquared = getTargetRadius() * getTargetRadius();
			
			Enemy farthest = null;
			
			for (Enemy e: GameState.getInstance().enemies.currentEnemies)
			{
				if ((x - e.getX()) * (x - e.getX()) + (y - e.getY()) * (y - e.getY()) < targetRadiusSquared)
				{
					if (farthest == null || farthest.getTotalDistance() < e.getTotalDistance())
					{
						farthest = e;
					}
				}
			}
			
			return farthest;
		}
	 
	 public static Tower getTower(TowerType type)
		{
			switch(type)
			{
			case BASIC_TOWER:
				return new BasicTower();
			case AOE_TOWER:
				return new AoeTower();
			case POISON_TOWER:
				return new PoisionTower();
			case SLOW_TOWER:
				return new SlowTower();

			
			}
			
			throw new RuntimeException("No such tower for enum");
		}
	
	
}
