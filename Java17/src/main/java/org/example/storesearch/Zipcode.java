package org.example.storesearch;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Zipcode {
    private Integer zip;
    private String address;
    private Double lat;
    private Double lng;

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Zipcode(Integer zip, String address, Double lat, Double lng) {
        this.zip = zip;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Zipcode{" +
                "zip=" + zip +
                ", address='" + address + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
