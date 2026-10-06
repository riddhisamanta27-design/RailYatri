package com.railyatri.model;

import java.util.List;

public class Train {
    private String trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String duration;
    private List<TrainClass> classes;
    private List<String> runningDays;
    private List<Station> schedule;

    public Train() {}

    public Train(String trainNumber, String trainName, String source, String destination, String departureTime, String arrivalTime, String duration, List<TrainClass> classes, List<String> runningDays, List<Station> schedule) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
        this.classes = classes;
        this.runningDays = runningDays;
        this.schedule = schedule;
    }

    public String getTrainNumber() { return trainNumber; }
    public void setTrainNumber(String trainNumber) { this.trainNumber = trainNumber; }
    public String getTrainName() { return trainName; }
    public void setTrainName(String trainName) { this.trainName = trainName; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public List<TrainClass> getClasses() { return classes; }
    public void setClasses(List<TrainClass> classes) { this.classes = classes; }
    public List<String> getRunningDays() { return runningDays; }
    public void setRunningDays(List<String> runningDays) { this.runningDays = runningDays; }
    public List<Station> getSchedule() { return schedule; }
    public void setSchedule(List<Station> schedule) { this.schedule = schedule; }
}
