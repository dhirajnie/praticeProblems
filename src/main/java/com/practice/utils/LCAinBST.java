package com.practice.utils;

import java.util.*;
import java.io.*;


class Node
{
    Node left;
    Node right;
    int data;


    Node( int data )
    {
        this.data = data;
        left = null;
        right = null;
    }
}


public class LCAinBST
{

    /*
    class Node
        int data;
        Node left;
        Node right;
    */


    static Node result;


    public static boolean recur( Node root, int v1, int v2 )
    {

        if ( root == null  )
            return false;
        else if ( root.data == v1  ) {
            boolean rightStatus = recur( root.right,v1,v2 );
            if(rightStatus){
                result=root;
            }
           return true;
        }
        else if(root.data==v2){
            boolean leftStatus= recur( root.left,v1,v2 );
            if(leftStatus){
                result=root;
            }
            return true;
        }
        boolean leftStatus = recur( root.left, v1, v2 );
        boolean rightStatus = recur( root.right, v1, v2 );
        if ( leftStatus && rightStatus  && result==null) {

            result = root;
            return true;
        }
        if(leftStatus || rightStatus){
            return true;
        }


        return false;
    }


    public static Node lca( Node root, int v1, int v2 )
    {
        if(v2<v1){
            int temp = v1;
            v1=v2;
            v2=temp;
        }
        recur( root, v1, v2 );
        return result;

    }


    public static Node insert( Node root, int data )
    {
        if ( root == null ) {
            return new Node( data );
        } else {
            Node cur;
            if ( data <= root.data ) {
                cur = insert( root.left, data );
                root.left = cur;
            } else {
                cur = insert( root.right, data );
                root.right = cur;
            }
            return root;
        }
    }


    public static void main( String[] args )
    {
        Scanner scan = new Scanner( System.in );
        int t = scan.nextInt();
        Node root = null;
        while ( t-- > 0 ) {
            int data = scan.nextInt();
            root = insert( root, data );
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca( root, v1, v2 );
        System.out.println( ans.data );
    }
}
