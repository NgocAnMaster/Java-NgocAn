package org.example.flight;

import java.time.LocalDateTime;

public class DomesticFlight extends Flight {
    private String destCity;

    public DomesticFlight() {
    }

    public DomesticFlight(int number, LocalDateTime startTime, LocalDateTime endTime, String depCity, String depCountry, String depContinent, String destCity) {
        super(number, startTime, endTime, depCity, depCountry, depContinent);
        this.destCity = destCity;
    }

//    public DomesticFlight(int number, LocalDateTime startTime, LocalDateTime endTime, String depCity, String depCountry, String destCity) {
//        super(number, startTime, endTime, depCity, depCountry);
//        this.destCity = destCity;
//    }

    public String getDestCity() {
        return destCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    @Override
    public String toString() {
        return "(DomesticFlight) {" +
                "Số hiệu " + getNumber() +
                ", xuất phát " + getStartTime() +
                ", kết thúc " + getEndTime() +
                ", thành phố đi '" + getDepCity() + '\'' +
                ", quốc gia đi '" + getDepCountry() + '\'' +
                ", châu lục đi '" + getDepContinent() + '\'' +
                ", thành phố đến '" + destCity + '\'' +
                '}';
    }
    public double calculatePrice(double lat1, double lat2, double lon1,
                                 double lon2){
        double dosPrice;
        DisCal dosDist = new DisCal(lat1, lat2, lon1, lon2, 0, 0);
        dosPrice = dosDist.getDistance() * 1120;
        return dosPrice;
    }

    public String getFlightClass(){
        return "DomesticFlight";
    }
}
