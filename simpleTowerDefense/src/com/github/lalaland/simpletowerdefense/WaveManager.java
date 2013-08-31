package com.github.lalaland.simpletowerdefense;

public class WaveManager {

	int currentWave = 1;
	
	void executeWave()
	{
		int numGuys = (int) Math.pow(currentWave,1.5);
		currentWave++;
		GameState.getInstance().enemies.addGuys(numGuys);
	}
}
