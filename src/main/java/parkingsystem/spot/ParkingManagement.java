package parkingsystem.spot;

import parkingsystem.entity.Ticket;
import parkingsystem.entity.Vehicle;
import java.util.*;

public class ParkingManagement
{
    Map<Ticket, Vehicle> parkingRecord;
    SpotManagement spotManagement;



    Ticket parkVehicle(Vehicle vehicle){

        return null;
    }
    Vehicle unparkVehicle(Ticket ticket){

        spotManagement.freeUpSpot(ticket.getSpots());


        return null;

    }




}
