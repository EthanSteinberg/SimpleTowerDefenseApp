package com.github.lalaland.simpletowerdefense;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TowerManager {

	List<Tower> towers = new ArrayList<Tower>();
	
	public void update(float time)
	{
		for (Tower t: towers)
			t.update();
	}
	
	public void render(SpriteBatch batch)
	{
		for (Tower t: towers)
			t.render(batch);
	}
	
	

	
	public void addTower(Tower t)
	{
		towers.add(t);
	}
	
	
}
