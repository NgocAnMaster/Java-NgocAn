package org.example.flight;

import java.time.LocalDateTime;

public class OverseaFlight extends Flight {
    private String destCity;
    private String destCountry;
    private String destContinent;

    public OverseaFlight(int number, LocalDateTime startTime, LocalDateTime endTime, String depCity, String depCountry, String depContinent, String destCity, String destCountry, String destContinent) {
        super(number, startTime, endTime, depCity, depCountry, depContinent);
        this.destCity = destCity;
        this.destCountry = destCountry;
        this.destContinent = destContinent;
    }

    public OverseaFlight() {
    }

//    public OverseaFlight(int number, LocalDateTime startTime, LocalDateTime endTime, String depCity, String depCountry, String destCity, String destCountry) {
//        super(number, startTime, endTime, depCity, depCountry);
//        this.destCity = destCity;
//        this.destCountry = destCountry;
//    }

    public String getDestCity() {
        return destCity;
    }

    public void setDestCity(String destCity) {
        this.destCity = destCity;
    }

    public String getDestCountry() {
        return destCountry;
    }

    public void setDestCountry(String destCountry) {
        this.destCountry = destCountry;
    }

    @Override
    public String toString() {
        return "(OverseaFlight) {" +
                "Số hiệu " + getNumber() +
                ", xuất phát " + getStartTime() +
                ", kết thúc " + getEndTime() +
                ", thành phố đi '" + getDepCity() + '\'' +
                ", quốc gia đi '" + getDepCountry() + '\'' +
                ", châu lục đi '" + getDepContinent() + '\'' +
                ", thành phố đến '" + destCity + '\'' +
                ", quốc gia đến '" + destCountry + '\'' +
                ", châu lục đến '" + destContinent + '\'' +
                '}';
    }
    public double calculatePrice(double lat1, double lat2, double lon1,
                                 double lon2){
        double ovsPrice;
        DisCal ovsDist = new DisCal(lat1, lat2, lon1, lon2, 0, 0);
        if (getDepContinent().equals(destContinent)){
            ovsPrice = ovsDist.getDistance() * 1490;
        }
        else {
            ovsPrice = ovsDist.getDistance() * 1780;
        }
        return ovsPrice;
    }

    public String getFlightClass(){
        return "OverseaFlight";
    }
}
