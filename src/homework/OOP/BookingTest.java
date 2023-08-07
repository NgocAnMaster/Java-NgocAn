package homework.OOP;

public class BookingTest {
    public static void main(String[] args) {
        Booking ticket1 = new Booking("E1621J","08/07/2019", 2, 1620000, "premium", "Ngoc Son Beach");
        System.out.println(ticket1.ticketConfirmation(ticket1));
        System.out.println(ticket1.getBookingID()+" "+ticket1.getDepartureDate()+" "+ticket1.getNumberOfTickets()+" "+ticket1.getPrice()+" "+ticket1.getCabinType()+" "+ticket1.getDestination()+" "+ticket1.getTotalPrice());
        ticket1.setBookingID("M42E51");
        ticket1.setDepartureDate("27/07/2023");
        ticket1.setNumberOfTickets(4);
        ticket1.setPrice(350000);
        ticket1.setCabinType("VIP");
        ticket1.setDestination("Dao Phu Quoc");
        System.out.println(ticket1.ticketConfirmation(ticket1));
    }
}
