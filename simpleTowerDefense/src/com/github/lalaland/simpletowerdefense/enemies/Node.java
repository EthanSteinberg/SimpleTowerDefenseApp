package com.github.lalaland.simpletowerdefense.enemies;

import java.util.ArrayList;
import java.util.List;

import com.github.lalaland.simpletowerdefense.TowerMap;

public class Node implements Comparable<Node>{

    final int x;
    final int y;
    final Node prev;
    
    final int length;
    final int score;
    
    
    final TowerMap map;
    
    final static int[][] arr=
        {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
    
    boolean isValid()
    {
        return (x>0) && (y>0) && (x<TowerMap.width) && (y<TowerMap.height) && map.getPos(x, y) == 1;
    }
    
    boolean isGoal()
    {
        return (x== map.stopX) && (y ==map.stopY);
    }
    
    Node(int x, int y,Node prev)
    {
        this.x = x;
        this.y = y;
        this.length = prev.length+1;
        this.prev = prev;
        
        this.map = prev.map;
        
        this.score = getScore();
    }
    
    Node(TowerMap map)
    {
        this.x = map.startX;
        this.y = map.startY;
        this.length = 1;
        this.prev = null;
        
        this.map = map;
        
        this.score = getScore();
    }
    
    private int getScore()
    {
        return Math.abs(map.stopX - x) + Math.abs(map.stopY - y)+ length;
    }
    
    List<Node> getNeighbors()
    {
        List<Node> result = new ArrayList<Node>();
        
        for (int[] possib : arr)
        {
            Node next = new Node(x+possib[0],y+possib[1],this);
 
            if (next.isValid())
                result.add(next);
            
        }
        
        return result;
        
        
    }
    
    @Override
    public int compareTo(Node o) {
        if (score < o.score)
            return -1;
        else if (score > o.score)
            return 1;
        else 
            return 0;
    }
    
    @Override
    public boolean equals(Object arg0) {
        Node other= (Node) arg0;
        
        return x == other.x && y == other.y;
    }
    
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return y * TowerMap.width + x;
    }
}
