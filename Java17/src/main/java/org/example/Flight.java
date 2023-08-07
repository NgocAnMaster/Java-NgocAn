package org.example;

public class Flight {
    private int number;
    private String destination;

    public Flight() {
    }

    public Flight(int number, String destination) {
        this.number = number;
        this.destination = destination;
    }

    public void display(){
        System.out.println(number+". "+destination);
    }

    public int getNumber() {
        return number;
    }

    public String getDestination() {
        return destination;
    }
}
