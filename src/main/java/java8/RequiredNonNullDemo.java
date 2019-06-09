package java8;

import java.util.Objects;


public class RequiredNonNullDemo
{


    public static void main(String args[]){
        Person1 p = new Person1( null );

    }
}

class Person1{
    private final Address address;


    public Person1( Address address )
    {
        Objects.requireNonNull(address,"Object Cannot be null");

        this.address = address;
    }
}
class Address{

}