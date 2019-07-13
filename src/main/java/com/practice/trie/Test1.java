package com.practice.trie;

public class Test1
{
    public static void main(String a[]){
        Trie trie = new Trie();
        trie.addWord( "hack" );
        trie.addWord( "hackerrank" );

        System.out.println(trie);


    }
}
