package java8;


class FunctionalInfDemo
{
    public static void main( String args[] )
    {


        Demo d = new Demo();

        m1( () -> {
            d.x=90909;
            System.out.println( "Hello"+d.x );
        } );

    }

    public static void m1( MyFunInterfaceDemo infr )
    {
        infr.fun();
    }

}


interface MyFunInterfaceDemo
{
    public void fun();


}
class Demo{
    int x;
    Demo(){
        System.out.println("demo constructor called ");
    }
}
