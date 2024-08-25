package design_patterns.flightmanagement;

public class Seat {
    String seatNumber;
    String seatType;
    //

    public Seat(String seatNumber, Passanger passanger) {
        this.seatNumber = seatNumber;

    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

}
