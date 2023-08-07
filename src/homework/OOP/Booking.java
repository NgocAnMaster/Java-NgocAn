package homework.OOP;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class Booking {
    private String bookingID;
    private String departureDate;
    private int numberOfTickets;
    private long price;
    private String cabinType;
    private long totalPrice;
    private String destination;

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCabinType() {
        return cabinType;
    }

    public void setCabinType(String cabinType) {
        this.cabinType = cabinType;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Booking(String bookingID, String departureDate, int numberOfTickets, long price, String cabinType, String destination) {
        this.bookingID = bookingID;
        this.departureDate = departureDate;
        this.numberOfTickets = numberOfTickets;
        this.price = price;
        this.cabinType = cabinType;
        this.destination = destination;
    }

    public void totalPrice(long price){
        this.totalPrice = price*numberOfTickets;
    }

    @Override
    public String toString() {
        return "Ticket Information\n" +
                "Booking ID: '" + bookingID + '\'' +
                "\nDeparture Date: " + departureDate +
                "\nNumber Of Tickets: " + numberOfTickets +
                "\nPrice: " + price +
                "\nCabin Type: '" + cabinType + '\'' +
                "\nDestination: '" + destination + '\'' +
                "\nTotal Price: " + totalPrice +
                '\n';
    }

    public String ticketConfirmation(Booking ticket){
        totalPrice(this.price);
        return ticket.toString();
    }
}
