package parkingsystem.entity;

import java.util.*;
import java.util.Date;


public class Ticket
{
    List<Spot> spots;
    String ticketId;
    Date entryTIme;
    Date exitTime;


    public List<Spot> getSpots()
    {
        return spots;
    }


    public void setSpots( List<Spot> spots )
    {
        this.spots = spots;
    }


    public String getTicketId()
    {
        return ticketId;
    }


    public void setTicketId( String ticketId )
    {
        this.ticketId = ticketId;
    }


    public Date getEntryTIme()
    {
        return entryTIme;
    }


    public void setEntryTIme( Date entryTIme )
    {
        this.entryTIme = entryTIme;
    }


    public Date getExitTime()
    {
        return exitTime;
    }


    public void setExitTime( Date exitTime )
    {
        this.exitTime = exitTime;
    }
}
