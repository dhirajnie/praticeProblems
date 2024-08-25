package design_patterns.flightmanagement;

import java.util.HashMap;
import java.util.Map;

public class Flight {
    int flightNumber;
    Map<String,Seat> seats = new HashMap<>();
    String source;
    String destination;
    boolean isActive;



   synchronized boolean  allocateSeat(String seatNumber, Passanger passanger){
        // it has to be atomic
//        this.seats.get(seatNumber).setPassanger(passanger);
        return true;
    }

   synchronized boolean unAllocateSeat(String seatNumber){
//        this.seats.get(seatNumber).setPassanger(null);
        return true;
    }

}
