package thread.practice;

public enum Singleton
{
    INSTANCE( 1, "dhiraj" );
    final int value;
    final String name;


    Singleton( int value, String name )
    {
        this.value = value;
        this.name = name;
    }


    public int getValue()
    {
        return value;
    }


    public String getName()
    {
        return name;
    }


}
