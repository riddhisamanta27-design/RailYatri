package com.railyatri.model;

public class TrainClass {
    private String className;
    private double fare;
    private int availableSeats;
    private int maxRacSeats;
    private int currentRac;
    private int currentWaitingList;

    public TrainClass() {}

    public TrainClass(String className, double fare, int availableSeats, int maxRacSeats, int currentRac, int currentWaitingList) {
        this.className = className;
        this.fare = fare;
        this.availableSeats = availableSeats;
        this.maxRacSeats = maxRacSeats;
        this.currentRac = currentRac;
        this.currentWaitingList = currentWaitingList;
    }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }
    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
    public int getMaxRacSeats() { return maxRacSeats; }
    public void setMaxRacSeats(int maxRacSeats) { this.maxRacSeats = maxRacSeats; }
    public int getCurrentRac() { return currentRac; }
    public void setCurrentRac(int currentRac) { this.currentRac = currentRac; }
    public int getCurrentWaitingList() { return currentWaitingList; }
    public void setCurrentWaitingList(int currentWaitingList) { this.currentWaitingList = currentWaitingList; }

    public String getStatus() {
        if (availableSeats > 0) {
            return "AVAILABLE";
        } else if (currentRac < maxRacSeats) {
            return "RAC";
        } else {
            return "WAITING";
        }
    }

    public int getConfirmationProbability() {
        return calculateConfirmationProbability(getStatus(), availableSeats, getStatus().equals("RAC") ? currentRac + 1 : currentWaitingList + 1);
    }

    public int calculateConfirmationProbability(String status, int availableSeats, int waitingPosition) {
        if ("AVAILABLE".equals(status)) {
            if (availableSeats >= 40) return 98;
            if (availableSeats >= 20) return 90;
            if (availableSeats >= 10) return 80;
            return 60;
        } else if ("RAC".equals(status)) {
            if (waitingPosition <= 5) return 88;
            if (waitingPosition <= 10) return 72;
            return 55;
        } else if ("WAITING".equals(status)) {
            if (waitingPosition <= 5) return 82;
            if (waitingPosition <= 10) return 65;
            if (waitingPosition <= 20) return 45;
            if (waitingPosition <= 40) return 25;
            return 10;
        }
        return 0;
    }
}
