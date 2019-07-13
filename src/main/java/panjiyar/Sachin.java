package panjiyar;

public class Sachin implements Player
{
    @Override
    public void play()
    {
        System.out.println("Player playing ");
    }


    @Override
    public int kmRun()
    {


        return 10;
    }


    @Override
    public void run()
    {
        System.out.println("Player running ");

    }
}
