package com.github.lalaland.simpletowerdefense;

public class GameState {

    
    
    int health = 10;
    int money = 100;
    
    private GameState()
    {
        
    }
    
    private final static GameState state = new GameState();
    
    public static GameState getInstance()
    {      
        return state;
    }
}
