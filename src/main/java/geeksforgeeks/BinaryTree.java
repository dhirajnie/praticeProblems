package geeksforgeeks;

public class BinaryTree
{
    Node root;


    boolean isBST()
    {

        return isBSTUtil( root, Integer.MAX_VALUE, Integer.MIN_VALUE );
    }


    private boolean isBSTUtil( Node root, int maxValue, int minValue )
    {
        if ( root == null )
            return true;

        else if ( root.data > maxValue || root.data < minValue ) {
            return false;
        } else {

          return   isBSTUtil( root.left, root.data - 1, minValue ) && isBSTUtil( root.right, maxValue, root.data + 1 );


        }


    }


    public static void main( String args[] )
    {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node( 3 );
        tree.root.left = new Node( 2 );
        tree.root.right = new Node( 5 );
        tree.root.left.left = new Node( 1 );
        tree.root.left.right = new Node( 4 );

        if ( tree.isBST() )
            System.out.println( "IS BST" );
        else
            System.out.println( "Not a BST" );
    }
}



class Node
{
    int data;
    Node left, right;


    public Node( int item )
    {
        data = item;
        left = right = null;
    }
}

