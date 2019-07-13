package com.practice.trie;

import java.util.Scanner;


public class PrefixTest
{
    public static void main(String args[]){
        Trie trie = new Trie();

        System.out.println(trie.checkPrefix( "aab" ));
        trie.addWord( "aab" );
        System.out.println(trie.checkPrefix( "defgab" ));
        trie.addWord( "defgab" );
        System.out.println(trie.checkPrefix( "abcde" ));
        trie.addWord( "abcde" );
        System.out.println(trie);
        System.out.println(trie.checkPrefix( "aa" ));
        trie.addWord( "aabcde" );
        System.out.println(trie.checkPrefix( "cedaaa" ));
        trie.addWord( "cedaaa" );
        System.out.println(trie.checkPrefix( "bbbbbbbbbb" ));
        trie.addWord( "bbbbbbbbbb" );
        System.out.println(trie.checkPrefix( "jabjjjad" ));
        trie.addWord( "jabjjjad" );
        System.out.println(trie);

    }
    public static void main1(String ars[]){
        Trie trie = new Trie();
        Scanner sc= new Scanner( System.in );
        int n = sc.nextInt();
        while(n!=0){
            String input = sc.next();
            if(trie.checkPrefix( input )){
                break;
            }
            trie.addWord( input );

            --n;

        }
    }

}
