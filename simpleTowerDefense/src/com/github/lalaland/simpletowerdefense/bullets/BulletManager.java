package com.github.lalaland.simpletowerdefense.bullets;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;

public class BulletManager {

	List<Bullet> bullets = new ArrayList<Bullet>();
	
	public void fireBullet(float x, float y, Enemy target,BulletType type)
	{
		
		System.out.println("Bullet fired");
		
		Bullet b = new Bullet(x,y,target,type);

		
		bullets.add(b);
	}
	
	public void update(float time)
	{
		for (Bullet b : bullets)
			b.update(time);
	}
	
	public void render(SpriteBatch batch)
	{
		for (Bullet b : bullets)
			b.render(batch);
	}
}
