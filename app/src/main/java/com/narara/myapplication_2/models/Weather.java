package com.narara.myapplication_2.models;

public class Weather {
    private int imageRes;
    private String city;
    private String temp;

    @Override
    public String toString() {
        return "Weather{" +
                "imageRes=" + imageRes +
                ", city='" + city + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public Weather(int imageRes, String city, String temp) {
        this.imageRes = imageRes;
        this.city = city;
        this.temp = temp;
    }
}
