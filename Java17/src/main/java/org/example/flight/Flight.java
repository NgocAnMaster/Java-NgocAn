package org.example.flight;

import java.time.LocalDateTime;

public class Flight {
    private int number;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String depCity;
    private String depCountry;
    private String depContinent;

    public Flight(int number, LocalDateTime startTime, LocalDateTime endTime, String depCity, String depCountry, String depContinent) {
        this.number = number;
        this.startTime = startTime;
        this.endTime = endTime;
        this.depCity = depCity;
        this.depCountry = depCountry;
        this.depContinent = depContinent;
    }

    public Flight() {
    }

//    public Flight(int number, LocalDateTime startTime, LocalDateTime endTime, String depCity, String depCountry) {
//        this.number = number;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.depCity = depCity;
//        this.depCountry = depCountry;
//    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDepCity() {
        return depCity;
    }

    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }

    public String getDepCountry() {
        return depCountry;
    }

    public void setDepCountry(String depCountry) {
        this.depCountry = depCountry;
    }

    public String getDepContinent() {
        return depContinent;
    }

    public void setDepContinent(String depContinent) {
        this.depContinent = depContinent;
    }

    @Override
    public String toString() {
        return "(Flight) {" +
                "Số hiệu " + number +
                ", xuất phát " + startTime +
                ", kết thúc " + endTime +
                ", thành phố đi '" + depCity + '\'' +
                ", quốc gia đi '" + depCountry + '\'' +
                ", châu lục đi '" + depContinent + '\'' +
                '}';
    }

    public double calculatePrice(double lat1, double lat2, double lon1,
                                 double lon2){
          double price;
          DisCal dist = new DisCal(lat1, lat2, lon1, lon2, 0, 0);
          price = dist.getDistance();
          return price;
    }

    public String getFlightClass(){
        return "Flight";
    }
}
