package whatfix;

public class Test
{


    public static void main( String args[] )
    {
        BST bst = new BST();
        bst.addElement( new Node( 10 ) );
        bst.addElement( new Node( 5 ) );
        bst.addElement( new Node( 14 ) );
        bst.addElement( new Node( 3 ) );
        bst.addElement( new Node( 7 ) );
        bst.addElement( new Node( 6 ) );
        bst.addElement( new Node( 12 ) );
        bst.addElement( new Node( 11 ) );
        bst.addElement( new Node( 19 ) );
        bst.addElement( new Node( 23 ) );
        bst.addElement( new Node( 20 ) );

        bst.inOrder( bst.root );
        int source =10;
        int des =23 ;
        if(source==des){
            System.out.println(source);
        }
        Node LCA = bst.printPath( source, des );
        if(LCA==null){
            System.out.println("No common ancestor found between source and destination");
            return;
        }
        System.out.println( "LCA" + LCA.data );
        System.out.println( bst.getPath( LCA, source, des ) );


    }
}
