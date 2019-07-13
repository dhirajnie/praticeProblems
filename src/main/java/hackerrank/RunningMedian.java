package hackerrank;

import java.util.Random;


public class RunningMedian
{

    static Node head;


    static double getMid( Node node )
    {
        Node slowPointer = node;
        Node fastPointer = node;
        Node prev = node;
        while ( fastPointer != null && fastPointer.next != null ) {
            prev = slowPointer;
            slowPointer = slowPointer.next;

            fastPointer = fastPointer.next.next;
        }

        System.out.println( "Mid" + slowPointer.data );
        System.out.println("Prev "+prev.data);
        if ( fastPointer == null ) {
            return (double)( prev.data + slowPointer.data ) / 2;
        } else {
            return slowPointer.data;
        }
    }


    static void insertNode( Node node )
    {
        if ( head == null ) {
            head = node;
            return;
        }
        Node currentNode = head;
        while ( currentNode.next != null && currentNode.next.data < node.data ) {
            currentNode = currentNode.next;

        }
        if ( currentNode.data >= node.data ) {
            //insert front
            node.next = head;
            head = node;
        } else {
            //insert next from current element
            Node temp = currentNode.next;
            currentNode.next = node;
            node.next = temp;
        }

    }


    static void print( Node node )
    {
        while ( node != null ) {
            System.out.println( node.data );
            node = node.next;

        }
    }


    public static void main( String args[] )
    {
        for ( int i =1;i<=2;i++) {
            //            insertNode( new Node(-1) );
            //            insertNode( new Node(10) );
            //            insertNode( new Node(40) );
            insertNode( new Node( i ) );
            System.out.println( getMid( head ));
        }
        print( head );

    }


    static int getRandom()
    {
        Random rand = new Random();
        return rand.nextInt( 30 );
    }
}


class Node
{
    int data;
    Node next;


    public Node( int data )
    {
        this.data = data;
    }
}
