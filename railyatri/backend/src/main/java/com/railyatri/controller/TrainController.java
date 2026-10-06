package com.railyatri.controller;

import com.railyatri.model.Train;
import com.railyatri.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    @GetMapping("/{trainNumber}")
    public Train getTrainDetails(@PathVariable String trainNumber) {
        return trainService.getTrainByNumber(trainNumber);
    }

    @GetMapping("/search")
    public List<Train> searchTrains(@RequestParam String source, @RequestParam String destination) {
        return trainService.searchTrains(source, destination);
    }
    
    @GetMapping("/search-connecting")
    public List<List<Train>> searchConnectingTrains(@RequestParam String source, @RequestParam String destination) {
        return trainService.searchConnectingRoutes(source, destination);
    }
    
    @GetMapping("/{trainNumber}/status")
    public String getTrainStatus(@PathVariable String trainNumber) {
        Train train = trainService.getTrainByNumber(trainNumber);
        if (train == null || train.getSchedule().isEmpty()) {
            return "{\"status\": \"On Time\", \"currentStation\": \"Unknown\", \"delay\": \"0 min\"}";
        }
        int idx = Math.min(1, train.getSchedule().size() - 1);
        String currentStation = train.getSchedule().get(idx).getName() + " (" + train.getSchedule().get(idx).getCode() + ")";
        return "{\"status\": \"On Time\", \"currentStation\": \"" + currentStation + "\", \"delay\": \"0 min\"}";
    }
    
    @GetMapping("/{trainNumber}/schedule")
    public Train getTrainSchedule(@PathVariable String trainNumber) {
        return trainService.getTrainByNumber(trainNumber);
    }
}
