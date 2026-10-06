package com.railyatri.service;

import com.railyatri.model.Booking;
import com.railyatri.model.Passenger;
import com.railyatri.model.Train;
import com.railyatri.model.TrainClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    @Autowired
    private TrainService trainService;

    // Using HashMap to store bookings with PNR as key for O(1) lookup
    private HashMap<String, Booking> bookingsMap = new HashMap<>();
    
    // Queue follows FIFO (First In, First Out), so passengers who joined the waiting list earlier are processed first.
    private Queue<Passenger> waitingListQueue = new LinkedList<>();

    public Booking createBooking(Booking booking) {
        // Generate a random 10-digit PNR
        String pnr = String.valueOf((long) (Math.random() * 9000000000L) + 1000000000L);
        booking.setPnr(pnr);
        
        Train realTrain = trainService.getTrainByNumber(booking.getTrain().getTrainNumber());
        if (realTrain == null) return null;
        booking.setTrain(realTrain);
        
        String reqClass = booking.getTrainClass();
        if (reqClass == null && !booking.getPassengers().isEmpty()) {
            reqClass = booking.getPassengers().get(0).getClassType();
            booking.setTrainClass(reqClass);
        }
        
        TrainClass tClass = null;
        for (TrainClass tc : realTrain.getClasses()) {
            if (tc.getClassName().equalsIgnoreCase(reqClass)) {
                tClass = tc;
                break;
            }
        }
        
        if (tClass == null && !realTrain.getClasses().isEmpty()) {
            tClass = realTrain.getClasses().get(0);
            booking.setTrainClass(tClass.getClassName());
        }

        if (tClass != null) {
            booking.setProbabilityAtBooking(tClass.getConfirmationProbability());
            
            boolean isWaitlistBooking = false;
            
            for (Passenger p : booking.getPassengers()) {
                p.setClassType(tClass.getClassName());
                if (tClass.getAvailableSeats() > 0) {
                    tClass.setAvailableSeats(tClass.getAvailableSeats() - 1);
                    p.setStatus("Confirmed");
                    p.setSeatNumber(tClass.getClassName() + " - " + ((int)(Math.random() * 50) + 1));
                } else if (tClass.getCurrentRac() < tClass.getMaxRacSeats()) {
                    tClass.setCurrentRac(tClass.getCurrentRac() + 1);
                    p.setStatus("RAC");
                    p.setSeatNumber("RAC " + tClass.getCurrentRac());
                } else {
                    tClass.setCurrentWaitingList(tClass.getCurrentWaitingList() + 1);
                    p.setStatus("Waiting List");
                    p.setSeatNumber("WL " + tClass.getCurrentWaitingList());
                    waitingListQueue.add(p);
                    isWaitlistBooking = true;
                }
            }
            
            if (isWaitlistBooking) {
                booking.setStatus("Waiting List");
            } else {
                booking.setStatus("Confirmed");
                for (Passenger p : booking.getPassengers()) {
                    if (p.getStatus().equals("RAC")) {
                        booking.setStatus("RAC");
                    }
                }
            }
        }

        bookingsMap.put(pnr, booking);
        return booking;
    }

    public Booking getBookingByPnr(String pnr) {
        return bookingsMap.get(pnr);
    }

    public boolean cancelBooking(String pnr) {
        Booking booking = bookingsMap.get(pnr);
        if (booking != null && !booking.getStatus().equals("Cancelled")) {
            booking.setStatus("Cancelled");
            
            Train realTrain = booking.getTrain();
            TrainClass tClass = null;
            if (realTrain != null && realTrain.getClasses() != null) {
                for (TrainClass tc : realTrain.getClasses()) {
                    if (tc.getClassName().equalsIgnoreCase(booking.getTrainClass())) {
                        tClass = tc;
                        break;
                    }
                }
            }
            
            for(Passenger p : booking.getPassengers()) {
                if (p.getStatus().equals("Confirmed")) {
                    if (tClass != null) {
                        tClass.setAvailableSeats(tClass.getAvailableSeats() + 1);
                        promoteWaitingList(tClass);
                    }
                } else if (p.getStatus().equals("RAC")) {
                    if (tClass != null) {
                        tClass.setCurrentRac(Math.max(0, tClass.getCurrentRac() - 1));
                    }
                } else if (p.getStatus().equals("Waiting List")) {
                    if (tClass != null) {
                        tClass.setCurrentWaitingList(Math.max(0, tClass.getCurrentWaitingList() - 1));
                    }
                    waitingListQueue.remove(p);
                }
                p.setStatus("Cancelled");
            }
            return true;
        }
        return false;
    }
    
    private void promoteWaitingList(TrainClass tClass) {
        Passenger toPromote = null;
        for (Passenger p : waitingListQueue) {
             if (p.getClassType() != null && p.getClassType().equals(tClass.getClassName()) && p.getStatus().equals("Waiting List")) {
                 toPromote = p;
                 break;
             }
        }
        if (toPromote != null) {
             waitingListQueue.remove(toPromote);
             toPromote.setStatus("Confirmed");
             toPromote.setSeatNumber(tClass.getClassName() + " - " + ((int)(Math.random() * 50) + 1));
             tClass.setAvailableSeats(tClass.getAvailableSeats() - 1);
             tClass.setCurrentWaitingList(Math.max(0, tClass.getCurrentWaitingList() - 1));
        }
    }
    
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookingsMap.values());
    }
}
