package com.github.lalaland.simpletowerdefense.effects;

import com.github.lalaland.simpletowerdefense.GameState;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;

public class SlowEffect extends Effect {

	Enemy enemyTargeted;
	
	float startTime;
	final static float duration = 3;
	
	public SlowEffect(Enemy e) {
		enemyTargeted = e;
		enemyTargeted.slows++;
		
		startTime = GameState.getInstance().clock.getTime();
	}

	@Override
	public void update(float delta) {
		if (isDead())
			return;
		
		
		
		
		if (GameState.getInstance().clock.getTime() > startTime + duration)
		{
			enemyTargeted.slows--;
			enemyTargeted = null;
		}

	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return enemyTargeted == null || enemyTargeted.isDead();
	}

}
