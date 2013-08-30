package com.github.lalaland.simpletowerdefense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.Json;
import com.github.lalaland.simpletowerdefense.towers.Tower;

public class TowerMap {
    
    static class JsonFormat
    {
        int[] arena;
        
        int startX;
        int startY;
        
        int stopX;
        int stopY;
    }
    
    JsonFormat tmp = new JsonFormat();

    public final static int height = 15;
    public final static int width = 20;
    
    public Rectangle boundingRect = new Rectangle(0, 0, 19.5f,14.5f);
    
    int[] arena;
    
    public int startX = 0;
    public int startY = 0;
    
    public int stopX = 1;
    public int stopY = 0;
    
    Json j = new Json();
    
    IntMap<Tower> towers = new IntMap<Tower>();
    List<Tower> towersList = new ArrayList<Tower>();
    
    public TowerMap() {
        arena = new int[width*height];
        
    }
    
    public TowerMap(FileHandle loadFrom)
    {
        load(loadFrom);
    }
    
    public void load(FileHandle loadFrom)
    {
        
        tmp = j.fromJson(JsonFormat.class, loadFrom);
        
        arena = tmp.arena;
        
        startX = tmp.startX;
        startY = tmp.startY;
        
        stopX = tmp.stopX;
        stopY = tmp.stopY;
    }
    
    public void save(FileHandle saveTo)
    {
        tmp.arena = arena;
        
        tmp.startX = startX;
        tmp.startY = startY;
        
        tmp.stopX = stopX;
        tmp.stopY = stopY;
        
        j.toJson(tmp, JsonFormat.class, saveTo);
    }
    
    public void setPos(int x, int y, int color)
    {
        arena[y*width + x] = color;
    }
    
    public void setTower(Tower t)
    {
    	towers.put(getIndex(t.getX(),t.getY()), t);
    	towersList.add(t);
    }
    
    public int getIndex(int x, int y)
    {
    	return y * width + x;
    }
   
    
    public int getPos(int x, int y)
    {
        return arena[y*width + x];
    }
    
    public Tower getTower(int x, int y)
    {
    	return towers.get(getIndex(x,y));
    }
    
    boolean insideArena(int x, int y)
    {
    	return boundingRect.contains(x, y);
    }
    
    boolean isGrass(int x, int y)
    {
    	return getPos(x,y) == 0;
    }
    
    boolean noTower(int x, int y)
    {
    	return getTower(x, y) == null;
    }
    
    public boolean validPlaceForTower(int x, int y)
    {
    	
    	return insideArena(x,y) && isGrass(x,y) && noTower(x,y); 
    
    }


    
    
}
