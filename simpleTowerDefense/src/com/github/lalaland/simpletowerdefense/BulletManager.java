package com.github.lalaland.simpletowerdefense;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BulletManager {

	List<Bullet> bullets = new ArrayList<Bullet>();
	
	public void fireBullet(float x, float y, Enemy target)
	{
		
		System.out.println("Bullet fired");
		
		Bullet b = new Bullet();
		b.x = x;
		b.y = y;
		b.target = target;
		
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
