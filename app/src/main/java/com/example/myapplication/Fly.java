package com.example.myapplication;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Fly {
    private  String airport_Two;
    private  String airport_one;
    private  String departure_one;
    private  String departure_time_Two;
    private  String departure_time_one;
    private  String price;

    public Fly() {
    }

    public Fly(String airport_Two, String airport_one, String departure_one, String departure_time_Two, String departure_time_one, String price) {
        this.airport_Two = airport_Two;
        this.airport_one = airport_one;
        this.departure_one = departure_one;
        this.departure_time_Two = departure_time_Two;
        this.departure_time_one = departure_time_one;
        this.price = price;
    }

    public String getAirport_Two() {
        return airport_Two;
    }

    public String getAirport_one() {
        return airport_one;
    }

    public String getDeparture_one() {
        return departure_one;
    }

    public String getDeparture_time_Two() {
        return departure_time_Two;
    }

    public String getDeparture_time_one() {
        return departure_time_one;
    }

    public String getPrice() {
        return price;
    }

    public void setAirport_Two(String airport_Two) {
        this.airport_Two = airport_Two;
    }

    public void setAirport_one(String airport_one) {
        this.airport_one = airport_one;
    }

    public void setDeparture_one(String departure_one) {
        this.departure_one = departure_one;
    }

    public void setDeparture_time_Two(String departure_time_Two) {
        this.departure_time_Two = departure_time_Two;
    }

    public void setDeparture_time_one(String departure_time_one) {
        this.departure_time_one = departure_time_one;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
