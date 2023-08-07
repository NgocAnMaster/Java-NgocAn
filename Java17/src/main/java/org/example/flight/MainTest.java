package org.example.flight;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) {
        // khoi tao mot list cac chuyen bay
        List<Flight> flightList = List.of(
            new DomesticFlight(141, ZonedDateTime.of(2023, 8, 4, 12, 0, 0, 0, ZoneId.of("Asia/Bangkok")).toLocalDateTime(), ZonedDateTime.of(2023, 8, 4, 16, 20, 0, 0, ZoneId.of("Asia/Bangkok")).toLocalDateTime(), "Ho Chi Minh City", "Viet Nam", "Asia", "Ha Noi"),
            new DomesticFlight(243, ZonedDateTime.of(2023, 8, 6, 20, 0, 0, 0, ZoneId.of("Asia/Bangkok")).toLocalDateTime(), ZonedDateTime.of(2023, 8, 6, 21, 10, 0, 0, ZoneId.of("Asia/Bangkok")).toLocalDateTime(), "Ho Chi Minh City", "Viet Nam", "Asia", "Nha Trang"),
            new OverseaFlight(420, ZonedDateTime.of(2023, 8, 4, 12, 0, 0, 0, ZoneId.of("Asia/Bangkok")).toLocalDateTime(), ZonedDateTime.of(2023, 8, 5, 2, 15, 0, 0, ZoneId.of("Asia/Bangkok")).toLocalDateTime(), "Ha Noi", "Viet Nam", "Asia", "New York","USA", "America"),
            new DomesticFlight(141, ZonedDateTime.of(2023, 8, 4, 0, 0, 0, 0, ZoneId.of("Asia/Bangkok")).toLocalDateTime(), ZonedDateTime.of(2023, 8, 4, 8, 0, 0, 0, ZoneId.of("Asia/Bangkok")).toLocalDateTime(), "Ho Chi Minh City", "Viet Nam", "Asia", "Ha Noi"),
            new OverseaFlight(420, ZonedDateTime.of(2023, 8, 4, 18, 45, 0, 0, ZoneId.of("Asia/Bangkok")).toLocalDateTime(), ZonedDateTime.of(2023, 8, 5, 17, 35, 0, 0, ZoneId.of("Asia/Bangkok")).toLocalDateTime(), "Ho Chi Minh City", "Viet Nam", "Asia", "New York","USA", "America")
        );
        System.out.println(flightList);

        // Part 1
        // Q1: Tim cac chuyen bay noi dia den Ha Noi trong ngay 4/8/2023
        System.out.println("Chuyến bay nội địa đến Hà Nội trong ngày 4/8/2023:");
        List<Flight> hanoiDomesticInAug4 = flightList.stream()
                .filter(flight -> flight instanceof DomesticFlight)
                .filter(s -> ((DomesticFlight) s).getDestCity().equals("Ha Noi"))
                .filter(flight -> flight.getStartTime().toLocalDate().equals(LocalDate.of(2023, 8, 4)))
                .collect(Collectors.toList());
        System.out.println(hanoiDomesticInAug4);

        // Q2: Tim cac chuyen bay quoc te di tu Ha Noi, Viet Nam trong ngay 4/8/2023
        List<Flight> internationalFlightFromHanoi4Aug = flightList.stream()
                .filter(flight -> flight instanceof OverseaFlight)
                .filter(flight -> flight.getDepCountry().equals("Viet Nam"))
                .filter(flight -> flight.getDepCity().equals("Ha Noi"))
                .collect(Collectors.toList());
        System.out.println("Chuyến bay quốc tế đi từ Hà Nội, Việt Nam trong ngày 4/8/2023:");
        System.out.println(internationalFlightFromHanoi4Aug);

        // Part 2
        // Khởi tạo danh sách các địa điểm List<Location>
        // chứa tất cả điểm bay đi/đến và kinh độ, vĩ độ tương ứng
        System.out.println("---------------------------------------------");
        Location l1 = Location.builder()
                .city("Ha Noi")
                .country("Viet Nam")
                .continent("Asia")
                .latitude(21.0228148)
                .longitude(105.7957636)
                .build();
        Location l2 = Location.builder()
                .city("Nha Trang")
                .country("Viet Nam")
                .continent("Asia")
                .latitude(12.2597565)
                .longitude(109.0816842)
                .build();
        Location l3 = Location.builder()
                .city("Ho Chi Minh City")
                .country("Viet Nam")
                .continent("Asia")
                .latitude(10.7539039)
                .longitude(105.5120266)
                .build();
        Location l4 = Location.builder()
                .city("New York")
                .country("USA")
                .continent("America")
                .latitude(40.6975399)
                .longitude(-74.3093428)
                .build();
        List<Location> locations = List.of(l1, l2, l3, l4);
        System.out.println(locations);

        // Với cách tính giá vé (VND) cho từng chuyến bay như sau:
        //Nội địa: 1120 * khoảng cách (km)
        //Quốc tế:
        //- Nếu 2 quốc gia cùng châu lục: 1490 * khoảng cách (km)
        //- Nếu 2 quốc gia khác châu lục: 1780 * khoảng cách (km)
        //Thêm method calculatePrice() vào các class Flight,
        //DomesticFlight và OverseaFlight. In ra giá vé tương ứng với từng chuyến bay.
        System.out.println("---------------------------------------------");
        System.out.println("Giá của các chuyến bay:");
        List<Double> flightPrice = new ArrayList<>();
        for (Flight flight : flightList){
            Location departureCity = null;
            Location destinationCity = null;
            if (flight.getFlightClass().equals("DomesticFlight")){
                for (int i = 0; i < locations.size(); i++){
                    if (flight.getDepCity().equals(locations.get(i).getCity())){
                        departureCity = locations.get(i);
                    }
                    if (((DomesticFlight) flight).getDestCity().equals(locations.get(i).getCity())){
                        destinationCity = locations.get(i);
                    }
                }
//                assert departureCity != null;
//                assert destinationCity != null;
                System.out.println("Chuyến bay nội địa từ " + departureCity.getCity() + " đến " + destinationCity.getCity() + " - Giá " + ((DomesticFlight) flight).calculatePrice(departureCity.getLatitude(),destinationCity.getLatitude(), departureCity.getLongitude(), destinationCity.getLongitude()));
                System.out.println("---------------------------------------------");
            } else if (flight.getFlightClass().equals("OverseaFlight")) {
                for (int i = 0; i < locations.size(); i++){
                    if (flight.getDepCity().equals(locations.get(i).getCity())){
                        departureCity = locations.get(i);
                    }
                    if (((OverseaFlight) flight).getDestCity().equals(locations.get(i).getCity())){
                        destinationCity = locations.get(i);
                    }
                }
//                    assert departureCity != null;
//                    assert destinationCity != null;
                System.out.println("Chuyến bay quốc tế từ " + departureCity.getCity() + ", " + departureCity.getCountry() + ", " + departureCity.getContinent() + " đến " + destinationCity.getCity() + ", " + destinationCity.getCountry() + ", " + destinationCity.getContinent() + " - Giá " + ((OverseaFlight) flight).calculatePrice(departureCity.getLatitude(),destinationCity.getLatitude(), departureCity.getLongitude(), destinationCity.getLongitude()));
                System.out.println("---------------------------------------------");
            }
        }
    }
}
