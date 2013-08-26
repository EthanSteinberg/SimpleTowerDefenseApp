package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

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
    
    int[] arena;
    
    int startX = 0;
    int startY = 0;
    
    int stopX = 1;
    int stopY = 0;
    
    Json j = new Json();
    
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
    
    public int getPos(int x, int y)
    {
        return arena[y*width + x];
    }
    
    
}
