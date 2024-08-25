package design_patterns.flightmanagement;

public class BookingManagent {

    PaymentManagement paymentManagement;
    AirlineManagement airlineManagement;

    BookingDetails bookTicket(BookingRequest bookingRequest) {
        Flight flight = null;
        flight.allocateSeat(null, null);
        paymentManagement.payment( 101);
        return null;
    }

    BookingDetails cancelTicket(BookingRequest bookingRequest) {
        return null;
    }
}
