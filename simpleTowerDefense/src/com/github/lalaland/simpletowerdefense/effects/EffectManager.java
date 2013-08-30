package com.github.lalaland.simpletowerdefense.effects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class EffectManager {

	List<Effect> effects = new ArrayList<Effect>();
	
	public void addEffect(Effect e)
	{
		effects.add(e);
	}
	
	public void update(float delta)
	{
		Iterator<Effect> it = effects.iterator();
        while (it.hasNext())
        {
        	Effect e = it.next();
            
            e.update(delta);
            
            if (e.isDead())
            {
                it.remove();
               
            }
        }
	}

	public void render(SpriteBatch batch) {
		for (Effect e : effects)
			e.render(batch);
		
	}
	
}
