package panjiyar;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;
import java.util.stream.Collectors;

import static javax.swing.text.html.parser.DTDConstants.ID;


public class Basics
{
    public static void main( String args[] )
    {


    }
}


class Person
{
    int ID;
    int age;
    String name;


    public Person( int age, String name, int ID )
    {
        this.age = age;
        this.name = name;
        this.ID = ID;
    }


    @Override
    public String toString()
    {
        return "Person{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
