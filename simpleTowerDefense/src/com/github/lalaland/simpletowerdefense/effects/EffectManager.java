package com.github.lalaland.simpletowerdefense.effects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.github.lalaland.simpletowerdefense.enemies.Enemy;


public class EffectManager {

	DelayedRemovalArray<Effect> effects = new DelayedRemovalArray<Effect>();
	
	public void addEffect(Effect e)
	{
		effects.add(e);
	}
	
	public void update(float delta)
	{
		effects.begin();
        for (int i = 0;i < effects.size; i++)
        {
            Effect e = effects.get(i);
            
            e.update(delta);
            
            if (e.isDead())
            {
            	effects.removeIndex(i);
               
            }
        }
        
        effects.end();
	}

	public void render(SpriteBatch batch) {
		for (Effect e : effects)
			e.render(batch);
		
	}
	
}
