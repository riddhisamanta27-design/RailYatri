package com.railyatri.model;

import java.util.List;

public class Booking {
    private String pnr;
    private Train train;
    private List<Passenger> passengers;
    private String journeyDate;
    private String status;
    private double totalFare;
    private String trainClass;
    private int probabilityAtBooking;
    
    public Booking() {}

    public String getPnr() { return pnr; }
    public void setPnr(String pnr) { this.pnr = pnr; }
    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }
    public List<Passenger> getPassengers() { return passengers; }
    public void setPassengers(List<Passenger> passengers) { this.passengers = passengers; }
    public String getJourneyDate() { return journeyDate; }
    public void setJourneyDate(String journeyDate) { this.journeyDate = journeyDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalFare() { return totalFare; }
    public void setTotalFare(double totalFare) { this.totalFare = totalFare; }
    public String getTrainClass() { return trainClass; }
    public void setTrainClass(String trainClass) { this.trainClass = trainClass; }
    public int getProbabilityAtBooking() { return probabilityAtBooking; }
    public void setProbabilityAtBooking(int probabilityAtBooking) { this.probabilityAtBooking = probabilityAtBooking; }
}
