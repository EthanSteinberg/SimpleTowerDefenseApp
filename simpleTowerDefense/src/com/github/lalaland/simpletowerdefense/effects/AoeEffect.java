package com.github.lalaland.simpletowerdefense.effects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.github.lalaland.simpletowerdefense.GameState;
import com.github.lalaland.simpletowerdefense.Resources;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;

public class AoeEffect extends Effect {

	Enemy enemyTargeted;
	
	float startTime;
	final static float duration = 1;
	
	public AoeEffect(Enemy e) {
		enemyTargeted = e;
		//enemyTargeted.explosions++;
		
		startTime = GameState.getInstance().clock.getTime();
		
		
		float x = e.getX();
		float y = e.getY();
		for (Enemy enemy : GameState.getInstance().enemies.getCurrentEnemies())
		{
			if ( (enemy.getX() -x) * (enemy.getX() -x) + (enemy.getY() - y) * (enemy.getY() -y)<4)
				enemy.damage(10);
			
		}
	}

	@Override
	public void update(float delta) {
		if (isDead())
			return;
		
		
		
		
		if (GameState.getInstance().clock.getTime() > startTime + duration)
		{
			enemyTargeted = null;
		}
			
			

	}
	
	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		batch.draw(Resources.explosion,enemyTargeted.getX()-.5f,enemyTargeted.getY() - .5f,2,2,0,1,1,0);
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return enemyTargeted == null || enemyTargeted.isDead();
	}

}
