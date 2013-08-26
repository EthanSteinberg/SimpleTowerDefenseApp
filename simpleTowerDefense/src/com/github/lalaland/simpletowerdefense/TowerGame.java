package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.Game;

public class TowerGame extends Game {

    
    
    
    MenuScreen menuScreen;
    TowerScreen towerScreen;
    MapEditor mapEditScreen;
    
    @Override
    public void create() {
    	Resources.init();
    	
        menuScreen = new MenuScreen(this);
        towerScreen = new TowerScreen(this);
        mapEditScreen = new MapEditor(this);
        
        setScreen(new MenuScreen(this));
    }
    
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        super.dispose();
        
        menuScreen.dispose();
        towerScreen.dispose();
    }
	
    
	

}
