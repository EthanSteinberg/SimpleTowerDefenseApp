package com.github.lalaland.simpletowerdefense.enemies;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

import com.github.lalaland.simpletowerdefense.TowerMap;


public class AStarSearch {

    TowerMap map;
    ResultNode result;
    
    public AStarSearch(TowerMap map)
    {
        this.map = map;
        
        Node path = getPath();
        result = reverse(path);
        
        
    }
    
    public ResultNode getResult()
    {
        return result;
    }
    
    private Node getPath()
    {
        Set<Node> visited = new HashSet<Node>();
        PriorityQueue<Node> currentNodes = new PriorityQueue<Node>();
        
        Node startNode = new Node(map);
        
        currentNodes.add(startNode);
        
        while (!currentNodes.isEmpty())
        {
            Node next = currentNodes.poll();
            if (next.isGoal())
                return next;
            
            visited.add(next);
            
            for (Node possib : next.getNeighbors())
            {
                if (!visited.contains(possib))
                {
                    currentNodes.add(possib);
                }
            }
            
            
        }
        
        throw new RuntimeException("No possible path");
        
        
    }
    
    private ResultNode reverse(Node path)
    {
        Node current = path;
        LinkedList<ResultNode> result = new LinkedList<ResultNode>();
        while (current != null)
        {
            ResultNode n = new ResultNode();
            n.x = current.x;
            n.y = current.y;
            
            result.push(n);
            
            current = current.prev;
        }
        
        ResultNode finalResult = result.pop();
        ResultNode currentResult = finalResult;
        
        while (!result.isEmpty())
        {
            ResultNode n = result.pop();
            currentResult.next = n;
            currentResult = n;
            
        }
        
        
        
        return finalResult;
    }
}
