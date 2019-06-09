package java8;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class Practice2
{
    public static void main( String args[] )
    {


        Person person = new Person( 1, "dhiraj" );
        Person person1 = new Person( 2, "dhiraj" );
        List<Person> personList = new ArrayList<>();
        personList.add( person );
        personList.add( person1 );
        Collections.sort( personList, Comparator.comparing( Person::getName ).thenComparing( Person::getPersonId ) );

        List<Person> newSyncLit = Collections.synchronizedList( personList );

        newSyncLit.add( new Person( 1,"xy" ) );


        System.out.println( personList );

    }
}


class Person
{
    int personId;
    String name;


    public Person( int personId, String name )
    {
        this.personId = personId;
        this.name = name;
    }


    public int getPersonId()
    {
        return personId;
    }


    public void setPersonId( int personId )
    {
        this.personId = personId;
    }


    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }


    @Override
    public String toString()
    {
        return "Person{" + "personId=" + personId + ", name='" + name + '\'' + '}';
    }
}