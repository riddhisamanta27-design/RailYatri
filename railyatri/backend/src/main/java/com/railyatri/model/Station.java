package com.railyatri.model;

import java.util.List;

public class Station {
    private String code;
    private String name;
    private String arrivalTime;
    private String departureTime;
    private String halt;
    private int distance;

    public Station() {}

    public Station(String code, String name, String arrivalTime, String departureTime, String halt, int distance) {
        this.code = code;
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.halt = halt;
        this.distance = distance;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public String getHalt() { return halt; }
    public void setHalt(String halt) { this.halt = halt; }
    public int getDistance() { return distance; }
    public void setDistance(int distance) { this.distance = distance; }
}
