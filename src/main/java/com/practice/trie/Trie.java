package com.practice.trie;

import java.util.*;


public class Trie
{
    Node root = new Node();


    void addWord( String word )
    {
        Node currentNode = root;

        for ( int i = 0; i < word.length(); i++ ) {
            if ( currentNode.nextNode.containsKey( word.charAt( i ) ) ) {
                currentNode = currentNode.nextNode.get( word.charAt( i ) );
                currentNode.setNumberOfWords( currentNode.getNumberOfWords() + 1 );

            } else {
                Node node = new Node();
                currentNode.nextNode.put( word.charAt( i ), node );
                currentNode = node;
                currentNode.setNumberOfWords( 1 );
            }
        }
        currentNode.setTerminated( true );

    }


    int findWord( String word )
    {
        Node currentNode = root;

        for ( int i = 0; i < word.length(); i++ ) {
            if ( !currentNode.nextNode.containsKey( word.charAt( i ) ) ) {
                return 0;
            }
            currentNode = currentNode.nextNode.get( word.charAt( i ) );

        }
        return currentNode.numberOfWords;

    }


    boolean checkPrefix( String inp )
    {
        Node currentNode = root;

        for ( int i = 0; i < inp.length(); i++ ) {

            if ( currentNode!=null && currentNode.nextNode.containsKey( inp.charAt( i ) )  ) {
                Node node = currentNode.nextNode.get( inp.charAt( i ) );
                if( node!=null && node.isTerminated){
                    System.out.println("BAD SET");
                    System.out.println(inp);
                    return true;
                }
            }
            else{
                return false;
            }
           currentNode = currentNode.nextNode.get( inp.charAt( i ) );

        }
    return true;
    }


    @Override
    public String toString()
    {
        return "Trie{" + "root=" + root + '}';
    }
}


class Node
{
    boolean isTerminated;
    int numberOfWords;
    Map<Character, Node> nextNode = new HashMap<>();


    public boolean isTerminated()
    {
        return isTerminated;
    }


    public void setTerminated( boolean terminated )
    {
        isTerminated = terminated;
    }


    public int getNumberOfWords()
    {
        return numberOfWords;
    }


    public void setNumberOfWords( int numberOfWords )
    {
        this.numberOfWords = numberOfWords;
    }


    @Override
    public String toString()
    {
        return "Node{" + "isTerminated=" + isTerminated + ", numberOfWords=" + numberOfWords + ", nextNode=" + nextNode + '}';
    }
}
