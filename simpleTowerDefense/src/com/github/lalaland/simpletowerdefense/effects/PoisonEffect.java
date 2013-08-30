package com.github.lalaland.simpletowerdefense.effects;

import com.github.lalaland.simpletowerdefense.GameState;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;

public class PoisonEffect extends Effect {

	Enemy enemyTargeted;
	
	float startTime;
	final static float duration = 3;
	
	public PoisonEffect(Enemy e) {
		enemyTargeted = e;
		enemyTargeted.poisons++;
		
		startTime = GameState.getInstance().clock.getTime();
	}

	@Override
	public void update(float delta) {
		if (isDead())
			return;
		
		
		
		
		if (GameState.getInstance().clock.getTime() > startTime + duration)
		{
			enemyTargeted.poisons--;
			enemyTargeted = null;
		}
			
			

	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return enemyTargeted == null || enemyTargeted.isDead();
	}

}
