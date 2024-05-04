package com.example.homework5;

public class Location {
    private String name;
    private double latitude;
    private double longtitude;
    private int image;

    public Location(String name, double latitude, double longtitude, int image) {
        this.name = name;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.image=image;
    }
    public Location( double latitude, double longtitude, int image) {
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.image=image;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {

        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                '}';
    }
}