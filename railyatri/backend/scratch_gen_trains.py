import random

cities = ["Mumbai", "Delhi", "Ahmedabad", "Pune", "Surat", "Vadodara", "Jaipur", "Agra", "Bhopal", "Indore", "Kota", "Lucknow", "Kanpur", "Varanasi", "Patna", "Kolkata", "Bengaluru", "Chennai", "Hyderabad", "Nagpur", "Goa", "Bhubaneswar", "Ranchi", "Guwahati", "Amritsar", "Chandigarh"]

codes = {
    "Mumbai": "MMCT", "Delhi": "NDLS", "Ahmedabad": "ADI", "Pune": "PUNE", "Surat": "ST", "Vadodara": "BRC",
    "Jaipur": "JP", "Agra": "AGC", "Bhopal": "BPL", "Indore": "INDB", "Kota": "KOTA", "Lucknow": "LKO",
    "Kanpur": "CNB", "Varanasi": "BSB", "Patna": "PNBE", "Kolkata": "HWH", "Bengaluru": "SBC", "Chennai": "MAS",
    "Hyderabad": "SC", "Nagpur": "NGP", "Goa": "MAO", "Bhubaneswar": "BBS", "Ranchi": "RNC", "Guwahati": "GHY",
    "Amritsar": "ASR", "Chandigarh": "CDG"
}

routes = [
    ["Mumbai", "Surat", "Vadodara", "Delhi"],
    ["Mumbai", "Ahmedabad", "Jaipur", "Delhi"],
    ["Pune", "Mumbai", "Ahmedabad", "Jaipur"],
    ["Pune", "Hyderabad", "Bengaluru", "Chennai"],
    ["Chennai", "Bengaluru", "Mumbai"],
    ["Kolkata", "Varanasi", "Lucknow", "Delhi"],
    ["Kolkata", "Bhubaneswar", "Chennai"],
    ["Hyderabad", "Nagpur", "Bhopal", "Delhi"],
    ["Delhi", "Kanpur", "Patna", "Kolkata"],
    ["Bengaluru", "Hyderabad", "Nagpur", "Delhi"],
    ["Ahmedabad", "Surat", "Mumbai", "Pune"],
    ["Guwahati", "Patna", "Varanasi", "Delhi"],
    ["Amritsar", "Chandigarh", "Delhi", "Agra"],
    ["Goa", "Mumbai", "Surat", "Ahmedabad"],
    ["Ranchi", "Patna", "Lucknow", "Delhi"],
    ["Indore", "Bhopal", "Nagpur", "Hyderabad"],
    ["Kota", "Jaipur", "Delhi", "Chandigarh"]
]

train_types = ["Express", "Rajdhani", "Shatabdi", "Duronto", "Superfast", "Mail"]

def generate_java():
    out = """package com.railyatri.service;

import com.railyatri.model.Station;
import com.railyatri.model.Train;
import com.railyatri.model.TrainClass;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainService {
    
    private ArrayList<Train> trains = new ArrayList<>();

    public TrainService() {
        initializeTrains();
    }

    private void initializeTrains() {
"""
    train_number = 12000
    
    for _ in range(40):
        train_number += random.randint(1, 20)
        t_num_str = str(train_number)
        
        route = random.choice(routes)
        
        source = route[0]
        dest = route[-1]
        t_name = f"{source} {dest} {random.choice(train_types)}"
        
        out += f"        // {t_num_str} {t_name}\n"
        out += f"        List<Station> schedule{t_num_str} = Arrays.asList(\n"
        
        dist = 0
        hour = random.randint(0, 23)
        minute = random.choice([0, 15, 30, 45])
        
        for i, city in enumerate(route):
            code = codes[city]
            if i == 0:
                arr = "-"
                dep = f"{hour:02d}:{minute:02d}"
                halt = "-"
            elif i == len(route) - 1:
                hour = (hour + random.randint(3, 8)) % 24
                arr = f"{hour:02d}:{minute:02d}"
                dep = "-"
                halt = "-"
                dist += random.randint(200, 500)
            else:
                hour = (hour + random.randint(2, 5)) % 24
                arr = f"{hour:02d}:{minute:02d}"
                minute = (minute + 10) % 60
                if minute < 10:
                    hour = (hour + 1) % 24
                dep = f"{hour:02d}:{minute:02d}"
                halt = "10 min"
                dist += random.randint(150, 400)
                
            out += f'                new Station("{code}", "{city}", "{arr}", "{dep}", "{halt}", {dist}){"," if i < len(route)-1 else ""}\n'
            
        out += "        );\n"
        
        dep_time = f"{random.randint(0,23):02d}:{random.choice(['00','15','30','45'])}"
        arr_time = f"{random.randint(0,23):02d}:{random.choice(['00','15','30','45'])}"
        dur = f"{random.randint(5, 30)}h {random.choice(['00','15','30','45'])}m"
        
        out += f'        List<TrainClass> classes{t_num_str} = Arrays.asList(\n'
        
        classes = []
        if random.choice([True, False]):
            classes.append(f'new TrainClass("1A", {random.randint(2500,4000)}, {random.randint(0, 5)}, 2, {random.randint(0,2)}, {random.randint(0,5)})')
        classes.append(f'new TrainClass("2A", {random.randint(1500,2500)}, {random.randint(0, 15)}, 5, {random.randint(0,5)}, {random.randint(0,10)})')
        classes.append(f'new TrainClass("3A", {random.randint(1000,1500)}, {random.randint(0, 40)}, 10, {random.randint(0,10)}, {random.randint(0,20)})')
        if random.choice([True, False]):
            classes.append(f'new TrainClass("SL", {random.randint(400,1000)}, {random.randint(0, 100)}, 20, {random.randint(0,20)}, {random.randint(0,40)})')
            
        for i, c in enumerate(classes):
            out += f'                {c}{"," if i < len(classes)-1 else ""}\n'
            
        out += "        );\n"
        
        days = random.choice(['Arrays.asList("Daily")', 'Arrays.asList("Mon", "Wed", "Fri")', 'Arrays.asList("Tue", "Thu", "Sat")'])
        
        out += f'        trains.add(new Train("{t_num_str}", "{t_name}", "{codes[source]}", "{codes[dest]}", "{dep_time}", "{arr_time}", "{dur}", classes{t_num_str}, {days}, schedule{t_num_str}));\n\n'
        
    out += """    }

    public List<Train> getAllTrains() {
        return trains;
    }

    public Train getTrainByNumber(String trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber().equals(trainNumber)) {
                return train;
            }
        }
        return null;
    }

    public List<Train> searchTrains(String source, String destination) {
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination)) {
                result.add(train);
            }
        }
        return result;
    }
    
    // Connecting routes logic
    public List<List<Train>> searchConnectingRoutes(String source, String destination) {
        List<List<Train>> connectingRoutes = new ArrayList<>();
        
        // Very basic simple 1-stop connecting logic
        for (Train train1 : trains) {
            if (train1.getSource().equalsIgnoreCase(source)) {
                // Find where train1 goes
                String midStation = train1.getDestination();
                
                // Now find a train2 from midStation to destination
                for (Train train2 : trains) {
                    if (train2.getSource().equalsIgnoreCase(midStation) && train2.getDestination().equalsIgnoreCase(destination)) {
                        // Found a connection
                        if (!train1.getTrainNumber().equals(train2.getTrainNumber())) {
                            List<Train> route = new ArrayList<>();
                            route.add(train1);
                            route.add(train2);
                            connectingRoutes.add(route);
                            
                            if (connectingRoutes.size() >= 5) {
                                return connectingRoutes; // Return max 5 connections
                            }
                        }
                    }
                }
            }
        }
        return connectingRoutes;
    }
}
"""
    return out

with open("c:/Users/riddh/OneDrive/Desktop/RailYatri/railyatri/backend/src/main/java/com/railyatri/service/TrainService.java", "w") as f:
    f.write(generate_java())
