package com.practice.trie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;


public class Test
{
    private static final Scanner scanner = new Scanner( System.in );


    public static void main( String[] args ) throws IOException
    {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt( scanner.nextLine().trim() );

        String[][] queries = new String[queriesRows][2];

        for ( int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++ ) {
            String[] queriesRowItems = scanner.nextLine().split( " " );

            for ( int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++ ) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts( queries );


    }


    static int[] contacts( String[][] queries )
    {
        Trie trie = new Trie();
        List<Integer> output = new ArrayList<>();

        for ( int i = 0; i < queries.length; i++ ) {

            String query = queries[i][0];
            if ( query.equals( "add" ) ) {
                trie.addWord( queries[i][1] );
            } else {
                output.add( trie.findWord( queries[i][1] ) );
            }

        }

        int[] arr = output.stream().mapToInt( i -> i ).toArray();
        System.out.println( output );
        return arr;
    }


}
