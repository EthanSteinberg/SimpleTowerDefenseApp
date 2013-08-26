package com.github.lalaland.simpletowerdefense;

public class Enemy {
    ResultNode lastPosition;
    float position;
    
    public Enemy(ResultNode startingPosition) {
        lastPosition = startingPosition;
        position = 0;
    }
    
    void update(float time)
    {
        position+= time*3;
        
        if (position > 1)
        {
            lastPosition = lastPosition.next;
            position-=1;
        }
    }
    
    float getX()
    {
        return lastPosition.x + (lastPosition.next.x - lastPosition.x) * position;
    }
    
    float getY()
    {
        return lastPosition.y + (lastPosition.next.y - lastPosition.y) * position;
    }
    
    boolean isOffScreen()
    {
        return lastPosition.next == null;
    }
    
    
}
