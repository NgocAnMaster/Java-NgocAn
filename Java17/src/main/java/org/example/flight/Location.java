package org.example.flight;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Getter @Setter @SuperBuilder
public class Location {
    private String city;
    private String country;
    private String continent;
    private double latitude;
    private double longitude;

    public Location(String city, String country, String continent, double latitude, double longitude) {
        this.city = city;
        this.country = country;
        this.continent = continent;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "(Location) {" +
                "Thành phố '" + city + '\'' +
                ", quốc gia '" + country + '\'' +
                ", châu lục '" + continent + '\'' +
                ", vĩ độ " + latitude +
                ", kinh độ " + longitude +
                '}';
    }

}
