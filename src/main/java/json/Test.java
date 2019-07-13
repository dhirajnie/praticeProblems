package json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Test
{
public static void main(String arsg[]){

    StampDetails stampDetails = new StampDetails();
    stampDetails.list.add( new Node(12) );
    try {
        System.out.println( new ObjectMapper(  ).writeValueAsString( stampDetails ) );
    } catch ( JsonProcessingException e ) {
        e.printStackTrace();
    }
}
}


class StampDetails{
    List<Node > list = new ArrayList<>(  );


    public List<Node> getList()
    {
        return list;
    }


    public void setList( List<Node> list )
    {
        this.list = list;
    }
}
class Node{
    int data;


    public Node( int data )
    {
        this.data = data;
    }


    public int getData()
    {
        return data;
    }


    public void setData( int data )
    {
        this.data = data;
    }
}

