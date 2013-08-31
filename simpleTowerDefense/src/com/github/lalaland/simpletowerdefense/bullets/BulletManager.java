package com.github.lalaland.simpletowerdefense.bullets;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.Pool;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;

public class BulletManager {

	DelayedRemovalArray<Bullet> bullets = new DelayedRemovalArray(false,100);
	
	Pool<Bullet> bulletPool = new Pool<Bullet>()
			{
				@Override
				protected Bullet newObject() {
					// TODO Auto-generated method stub
					return new Bullet();
				}
		
			};
	
	public void fireBullet(float x, float y, Enemy target,BulletType type)
	{
		
		Bullet b = bulletPool.obtain();
		b.set(x,y,target,type);

		
		bullets.add(b);
	}
	
	public void update(float time)
	{
		bullets.begin();
		for (int i = 0; i < bullets.size; i++)
		{
			Bullet b = bullets.get(i);
			b.update(time);
			if (b.isDead())
			{
				bullets.removeIndex(i);
				bulletPool.free(b);
			}
		}
		bullets.end();
			
	}
	
	public void render(SpriteBatch batch)
	{
		for (Bullet b : bullets)
			b.render(batch);
	}
}
