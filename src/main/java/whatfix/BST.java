package whatfix;
import java.util.*;
public class BST
{

    Node root;


    void addElement( Node node )
    {
        if ( root == null )
            root = node;
        else {
            Node prev = root;
            Node cur = root;
            while ( cur != null ) {
                if ( cur.data < node.data ) {
                    prev = cur;
                    cur = cur.rightChild;

                } else {
                    prev = cur;
                    cur = cur.leftChild;
                }
            }
            if ( node.data > prev.data ) {
                prev.rightChild = node;
            } else {
                prev.leftChild = node;

            }
        }
    }


    void inOrder( Node node )
    {
        if ( node == null ) {
            return;
        } else {
            inOrder( node.leftChild );
            System.out.println( node.data );
            inOrder( node.rightChild );
        }
    }


    Node printPath(int firstElement,int secondElement){


        recur( firstElement,secondElement ,root);
        return LCA;


    }

    boolean firstFound=false;




   static Node LCA;





    boolean recur(int a,int b,Node root){
        if(root==null) {
            return false;
        }
        else if(root.data==a){

            if( recur( a,b,root.rightChild )==true){
                LCA=root;
            }

            return true;
        }
        else if(root.data==b){
     if( recur( a,b,root.leftChild )==true){
                LCA=root;
            }
            return true;

        }
        else{

           if( recur( a,b,root.leftChild ) && recur( a,b,root.rightChild )){
               LCA=root;
                System.out.println("LCA"+root.data);

            }

          else  if( recur( a,b,root.leftChild ) || recur( a,b,root.rightChild )){
                return true;
            }
        }
        return false;

    }
    List<Node> getPath(Node node ,int a,int b){
        Node cur=node;
        List<Node > path = new ArrayList<>(  );
        while ( cur!=null ){
            if(cur.data==a){
                path.add( cur );
                break;
            }
            if(cur.data<a){
                path.add( cur );
                cur=cur.rightChild;

            }
            else{
                path.add( cur );
                cur=cur.leftChild;
            }
        }
        path.remove( 0 );
        Collections.reverse( path );
        cur=node;


        while ( cur!=null ){
            if(cur.data==b){
                path.add( cur );
                break;
            }
            if(cur.data<b){
                path.add( cur );
                cur=cur.rightChild;

            }
            else{
                path.add( cur );
                cur=cur.leftChild;
            }
        }
        return path;
    }


}


class Node
{
    int data;
    Node leftChild;
    Node rightChild;


    public Node( int data )
    {
        this.data = data;
    }


    @Override
    public String toString()
    {
        return "Node{" + "data=" + data +"}" ;
    }
}
