package arrayRotation;


class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public static  void insertElement(int data, Node head){
        Node currentNode = head;
        Node preNode=head;
        while(currentNode!=null){
            preNode= currentNode;
            if(currentNode.data<data){
                currentNode= currentNode.left;
            }
            else{
                currentNode= currentNode.right;
            }
        }

        if(preNode.data>data){
            preNode.left= new Node(data);
        }
        else{
            preNode.right = new Node(data);
        }
    }

    public static void print(Node node){

        if(node==null){
            return;
        }
        else{
//            System.out.println("Node "+ node.data);
      print(node.left);
            System.out.println(node.data);
           print(node.right);
        }
    }



}
public class BST {
    public static void main(String[] args) {
        int input[]={5,6,71,2,4,6,7,90,87,987};
        if(input == null || input.length>0 ){
            Node tree = new Node(input[0]);
            for(int i =1;i<input.length;i++){
                Node.insertElement(input[i],tree);
            }
            Node.print(tree);
        }

    }
/*
Animal {
run
reproduce

}

Snake snake = new Snake()


Balance{

totalBalance


}

Phonpe
{
}
Gpay
{


}


12jtergv    WZ@gctfrdse
Cred{
loan
1`sra
edtf3r55
}


Cred {
loan

}








 */
}
