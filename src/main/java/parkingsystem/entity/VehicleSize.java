package parkingsystem.entity;

public enum VehicleSize
{
    SMALL(1),MEDIUM(2),LARGE(3);
    int size;


    VehicleSize( int size )
    {
        this.size = size;
    }


    public int getSize()
    {
        return size;
    }


    public void setSize( int size )
    {
        this.size = size;
    }
}
