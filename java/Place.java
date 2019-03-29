package com.anvipuri.trail;



public class Place {

    private int id;
    private String city;
    private String state;
    private String language;
    private String weather;
    private String cuisine;
    private String fandf;
    private String transport;

    public Place() {
    }

    public Place(int id, String city, String state, String language, String weather, String cuisine, String fandf, String transport) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.language = language;
        this.weather = weather;
        this.cuisine = cuisine;
        this.fandf = fandf;
        this.transport = transport;
    }

    public Place(String city, String state, String language, String weather, String cuisine, String fandf, String transport) {
        this.city = city;
        this.state = state;
        this.language = language;
        this.weather = weather;
        this.cuisine = cuisine;
        this.fandf = fandf;
        this.transport = transport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getFandf() {
        return fandf;
    }

    public void setFandf(String fandf) {
        this.fandf = fandf;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }
}
