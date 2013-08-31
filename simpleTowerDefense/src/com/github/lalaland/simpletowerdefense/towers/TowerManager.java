package com.github.lalaland.simpletowerdefense.towers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class TowerManager {
	
	Array<Tower> towers = new Array<Tower>(false,10);

	
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
