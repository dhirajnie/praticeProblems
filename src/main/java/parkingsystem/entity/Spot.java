package parkingsystem.entity;

public class Spot
{
    int spotId;
    String spotName;


    public Spot( int spotId, String spotName )
    {
        this.spotId = spotId;
        this.spotName = spotName;
    }


    public int getSpotId()
    {
        return spotId;
    }


    public void setSpotId( int spotId )
    {
        this.spotId = spotId;
    }


    public String getSpotName()
    {
        return spotName;
    }


    public void setSpotName( String spotName )
    {
        this.spotName = spotName;
    }
}
