package com.practice.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.*;

public class MinimumSteps
{

    static int minimumMoves( String[] grid, int startX, int startY, int goalX, int goalY )
    {
        if ( startX == goalX && startY == goalY ) {
            return 0;

        }

        Queue<Node> queue = new LinkedList<>();
        queue.add( new Node( startX, startY ) );
        int colLength = grid[0].length();
        boolean[] visted = new boolean[grid.length * colLength];
        int noOfMovement = 0;
        visted[startX * colLength + startY] = true;
        List<Node> pathToReachDist= new ArrayList<>(  );
        while ( true ) {

            Node node = queue.poll();
            visted[node.x * colLength + node.y] = true;

            if ( node.x == goalX && node.y == goalY ) {
                break;
            }
          ++noOfMovement;
            pathToReachDist.add( node );
            //right
            if ( node.y + 1 < grid[node.x].length() && grid[node.x].charAt( node.y + 1 ) == '.' && !visted[
                ( node.x ) * colLength + node.y + 1] ) {
                queue.add( new Node( node.x, node.y + 1 ) );
            }
            //left
            if ( node.y - 1 >= 0 && grid[node.x].charAt( node.y - 1 ) == '.' && !visted[( node.x ) * colLength + node.y - 1] ) {
                queue.add( new Node( node.x, node.y - 1 ) );
            }
            //up
            if ( node.x - 1 >= 0 && grid[node.x - 1].charAt( node.y ) == '.' && !visted[( node.x - 1 ) * colLength + node.y] ) {
                queue.add( new Node( node.x - 1, node.y ) );
            }
            //down
            if ( node.x + 1 < grid.length && grid[node.x + 1].charAt( node.y ) == '.' && !visted[( node.x + 1 ) * colLength
                + node.y] ) {
                queue.add( new Node( node.x + 1, node.y ) );
            }
            System.out.println( "move x" + node.x + " y" + node.y + " value " + grid[node.x].charAt( node.y ) );

        }

        System.out.println("path"+pathToReachDist);
        return noOfMovement;

    }


}


class Node
{
    int x;
    int y;


    public Node( int x, int y )
    {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
            return true;
        if ( !( o instanceof Node ) )
            return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }


    @Override
    public int hashCode()
    {
        return Objects.hash( x, y );
    }


    @Override
    public String toString()
    {
        return "Node{" + "x=" + x + ", y=" + y + '}';
    }
}
