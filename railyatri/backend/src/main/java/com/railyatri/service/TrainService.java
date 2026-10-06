package com.railyatri.service;

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
        // 12001 Amritsar Agra Duronto
        List<Station> schedule12001 = Arrays.asList(
                new Station("ASR", "Amritsar", "-", "03:15", "-", 0),
                new Station("CDG", "Chandigarh", "08:15", "08:25", "10 min", 349),
                new Station("NDLS", "Delhi", "12:25", "12:35", "10 min", 503),
                new Station("AGC", "Agra", "18:35", "-", "-", 813)
        );
        List<TrainClass> classes12001 = Arrays.asList(
                new TrainClass("1A", 3811, 4, 2, 1, 3),
                new TrainClass("2A", 2475, 4, 5, 2, 6),
                new TrainClass("3A", 1495, 21, 10, 3, 20),
                new TrainClass("SL", 543, 1, 20, 9, 33)
        );
        trains.add(new Train("12001", "Amritsar Agra Duronto", "ASR", "AGC", "01:15", "13:30", "21h 30m", classes12001, Arrays.asList("Daily"), schedule12001));

        // 12002 Delhi Kolkata Superfast
        List<Station> schedule12002 = Arrays.asList(
                new Station("NDLS", "Delhi", "-", "06:15", "-", 0),
                new Station("CNB", "Kanpur", "08:15", "08:25", "10 min", 303),
                new Station("PNBE", "Patna", "10:25", "10:35", "10 min", 602),
                new Station("HWH", "Kolkata", "13:35", "-", "-", 875)
        );
        List<TrainClass> classes12002 = Arrays.asList(
                new TrainClass("2A", 2228, 9, 5, 0, 6),
                new TrainClass("3A", 1474, 16, 10, 5, 7),
                new TrainClass("SL", 544, 99, 20, 18, 28)
        );
        trains.add(new Train("12002", "Delhi Kolkata Superfast", "NDLS", "HWH", "22:30", "08:15", "21h 15m", classes12002, Arrays.asList("Mon", "Wed", "Fri"), schedule12002));

        // 12004 Ahmedabad Pune Express
        List<Station> schedule12004 = Arrays.asList(
                new Station("ADI", "Ahmedabad", "-", "13:45", "-", 0),
                new Station("ST", "Surat", "18:45", "18:55", "10 min", 196),
                new Station("MMCT", "Mumbai", "21:55", "22:05", "10 min", 412),
                new Station("PUNE", "Pune", "01:05", "-", "-", 666)
        );
        List<TrainClass> classes12004 = Arrays.asList(
                new TrainClass("2A", 2485, 5, 5, 4, 5),
                new TrainClass("3A", 1157, 7, 10, 0, 4),
                new TrainClass("SL", 784, 37, 20, 6, 24)
        );
        trains.add(new Train("12004", "Ahmedabad Pune Express", "ADI", "PUNE", "05:30", "18:00", "15h 00m", classes12004, Arrays.asList("Mon", "Wed", "Fri"), schedule12004));

        // 12015 Pune Chennai Express
        List<Station> schedule12015 = Arrays.asList(
                new Station("PUNE", "Pune", "-", "03:15", "-", 0),
                new Station("SC", "Hyderabad", "06:15", "06:25", "10 min", 269),
                new Station("SBC", "Bengaluru", "10:25", "10:35", "10 min", 540),
                new Station("MAS", "Chennai", "14:35", "-", "-", 787)
        );
        List<TrainClass> classes12015 = Arrays.asList(
                new TrainClass("1A", 3259, 0, 2, 0, 4),
                new TrainClass("2A", 2461, 13, 5, 3, 5),
                new TrainClass("3A", 1106, 26, 10, 1, 6)
        );
        trains.add(new Train("12015", "Pune Chennai Express", "PUNE", "MAS", "09:45", "21:00", "28h 30m", classes12015, Arrays.asList("Daily"), schedule12015));

        // 12033 Guwahati Delhi Duronto
        List<Station> schedule12033 = Arrays.asList(
                new Station("GHY", "Guwahati", "-", "20:00", "-", 0),
                new Station("PNBE", "Patna", "00:00", "00:10", "10 min", 180),
                new Station("BSB", "Varanasi", "05:10", "05:20", "10 min", 461),
                new Station("NDLS", "Delhi", "11:20", "-", "-", 813)
        );
        List<TrainClass> classes12033 = Arrays.asList(
                new TrainClass("2A", 1586, 2, 5, 0, 9),
                new TrainClass("3A", 1084, 19, 10, 6, 17),
                new TrainClass("SL", 815, 73, 20, 18, 30)
        );
        trains.add(new Train("12033", "Guwahati Delhi Duronto", "GHY", "NDLS", "14:30", "23:00", "28h 00m", classes12033, Arrays.asList("Tue", "Thu", "Sat"), schedule12033));

        // 12048 Pune Chennai Superfast
        List<Station> schedule12048 = Arrays.asList(
                new Station("PUNE", "Pune", "-", "21:15", "-", 0),
                new Station("SC", "Hyderabad", "01:15", "01:25", "10 min", 267),
                new Station("SBC", "Bengaluru", "03:25", "03:35", "10 min", 448),
                new Station("MAS", "Chennai", "10:35", "-", "-", 826)
        );
        List<TrainClass> classes12048 = Arrays.asList(
                new TrainClass("1A", 3678, 0, 2, 1, 5),
                new TrainClass("2A", 2479, 0, 5, 4, 9),
                new TrainClass("3A", 1231, 3, 10, 7, 11),
                new TrainClass("SL", 524, 54, 20, 18, 18)
        );
        trains.add(new Train("12048", "Pune Chennai Superfast", "PUNE", "MAS", "07:15", "16:00", "25h 00m", classes12048, Arrays.asList("Mon", "Wed", "Fri"), schedule12048));

        // 12051 Mumbai Delhi Shatabdi
        List<Station> schedule12051 = Arrays.asList(
                new Station("MMCT", "Mumbai", "-", "04:45", "-", 0),
                new Station("ST", "Surat", "08:45", "08:55", "10 min", 170),
                new Station("BRC", "Vadodara", "10:55", "11:05", "10 min", 391),
                new Station("NDLS", "Delhi", "19:05", "-", "-", 701)
        );
        List<TrainClass> classes12051 = Arrays.asList(
                new TrainClass("2A", 2446, 9, 5, 3, 6),
                new TrainClass("3A", 1186, 23, 10, 3, 0),
                new TrainClass("SL", 737, 70, 20, 18, 21)
        );
        trains.add(new Train("12051", "Mumbai Delhi Shatabdi", "MMCT", "NDLS", "18:00", "04:30", "10h 45m", classes12051, Arrays.asList("Tue", "Thu", "Sat"), schedule12051));

        // 12069 Ahmedabad Pune Rajdhani
        List<Station> schedule12069 = Arrays.asList(
                new Station("ADI", "Ahmedabad", "-", "22:30", "-", 0),
                new Station("ST", "Surat", "02:30", "02:40", "10 min", 214),
                new Station("MMCT", "Mumbai", "06:40", "06:50", "10 min", 424),
                new Station("PUNE", "Pune", "13:50", "-", "-", 646)
        );
        List<TrainClass> classes12069 = Arrays.asList(
                new TrainClass("2A", 2464, 15, 5, 5, 3),
                new TrainClass("3A", 1435, 28, 10, 0, 4)
        );
        trains.add(new Train("12069", "Ahmedabad Pune Rajdhani", "ADI", "PUNE", "02:00", "16:30", "30h 00m", classes12069, Arrays.asList("Mon", "Wed", "Fri"), schedule12069));

        // 12074 Pune Chennai Rajdhani
        List<Station> schedule12074 = Arrays.asList(
                new Station("PUNE", "Pune", "-", "04:00", "-", 0),
                new Station("SC", "Hyderabad", "07:00", "07:10", "10 min", 292),
                new Station("SBC", "Bengaluru", "12:10", "12:20", "10 min", 597),
                new Station("MAS", "Chennai", "18:20", "-", "-", 815)
        );
        List<TrainClass> classes12074 = Arrays.asList(
                new TrainClass("2A", 2492, 8, 5, 4, 6),
                new TrainClass("3A", 1445, 15, 10, 9, 8),
                new TrainClass("SL", 657, 98, 20, 2, 40)
        );
        trains.add(new Train("12074", "Pune Chennai Rajdhani", "PUNE", "MAS", "01:15", "20:45", "5h 30m", classes12074, Arrays.asList("Mon", "Wed", "Fri"), schedule12074));

        // 12078 Goa Ahmedabad Superfast
        List<Station> schedule12078 = Arrays.asList(
                new Station("MAO", "Goa", "-", "00:45", "-", 0),
                new Station("MMCT", "Mumbai", "04:45", "04:55", "10 min", 376),
                new Station("ST", "Surat", "07:55", "08:05", "10 min", 741),
                new Station("ADI", "Ahmedabad", "12:05", "-", "-", 1084)
        );
        List<TrainClass> classes12078 = Arrays.asList(
                new TrainClass("2A", 1522, 3, 5, 3, 6),
                new TrainClass("3A", 1148, 2, 10, 7, 17),
                new TrainClass("SL", 767, 91, 20, 0, 34)
        );
        trains.add(new Train("12078", "Goa Ahmedabad Superfast", "MAO", "ADI", "17:30", "15:45", "16h 30m", classes12078, Arrays.asList("Daily"), schedule12078));

        // 12090 Mumbai Delhi Shatabdi
        List<Station> schedule12090 = Arrays.asList(
                new Station("MMCT", "Mumbai", "-", "11:45", "-", 0),
                new Station("ADI", "Ahmedabad", "13:45", "13:55", "10 min", 151),
                new Station("JP", "Jaipur", "16:55", "17:05", "10 min", 456),
                new Station("NDLS", "Delhi", "21:05", "-", "-", 829)
        );
        List<TrainClass> classes12090 = Arrays.asList(
                new TrainClass("1A", 3011, 0, 2, 1, 3),
                new TrainClass("2A", 1782, 15, 5, 0, 7),
                new TrainClass("3A", 1418, 34, 10, 6, 18),
                new TrainClass("SL", 876, 16, 20, 14, 15)
        );
        trains.add(new Train("12090", "Mumbai Delhi Shatabdi", "MMCT", "NDLS", "02:30", "07:15", "10h 00m", classes12090, Arrays.asList("Daily"), schedule12090));

        // 12096 Bengaluru Delhi Duronto
        List<Station> schedule12096 = Arrays.asList(
                new Station("SBC", "Bengaluru", "-", "07:15", "-", 0),
                new Station("SC", "Hyderabad", "12:15", "12:25", "10 min", 197),
                new Station("NGP", "Nagpur", "17:25", "17:35", "10 min", 348),
                new Station("NDLS", "Delhi", "01:35", "-", "-", 633)
        );
        List<TrainClass> classes12096 = Arrays.asList(
                new TrainClass("2A", 2338, 14, 5, 0, 4),
                new TrainClass("3A", 1054, 2, 10, 7, 14),
                new TrainClass("SL", 906, 28, 20, 0, 15)
        );
        trains.add(new Train("12096", "Bengaluru Delhi Duronto", "SBC", "NDLS", "22:15", "09:00", "6h 45m", classes12096, Arrays.asList("Mon", "Wed", "Fri"), schedule12096));

        // 12110 Kota Chandigarh Superfast
        List<Station> schedule12110 = Arrays.asList(
                new Station("KOTA", "Kota", "-", "02:00", "-", 0),
                new Station("JP", "Jaipur", "07:00", "07:10", "10 min", 249),
                new Station("NDLS", "Delhi", "10:10", "10:20", "10 min", 600),
                new Station("CDG", "Chandigarh", "15:20", "-", "-", 938)
        );
        List<TrainClass> classes12110 = Arrays.asList(
                new TrainClass("1A", 2565, 0, 2, 0, 0),
                new TrainClass("2A", 2129, 8, 5, 0, 2),
                new TrainClass("3A", 1181, 28, 10, 6, 20)
        );
        trains.add(new Train("12110", "Kota Chandigarh Superfast", "KOTA", "CDG", "17:15", "00:45", "15h 00m", classes12110, Arrays.asList("Daily"), schedule12110));

        // 12127 Guwahati Delhi Duronto
        List<Station> schedule12127 = Arrays.asList(
                new Station("GHY", "Guwahati", "-", "09:15", "-", 0),
                new Station("PNBE", "Patna", "13:15", "13:25", "10 min", 293),
                new Station("BSB", "Varanasi", "15:25", "15:35", "10 min", 587),
                new Station("NDLS", "Delhi", "20:35", "-", "-", 991)
        );
        List<TrainClass> classes12127 = Arrays.asList(
                new TrainClass("2A", 2268, 5, 5, 0, 3),
                new TrainClass("3A", 1031, 24, 10, 5, 1),
                new TrainClass("SL", 653, 31, 20, 2, 38)
        );
        trains.add(new Train("12127", "Guwahati Delhi Duronto", "GHY", "NDLS", "08:45", "09:15", "18h 30m", classes12127, Arrays.asList("Daily"), schedule12127));

        // 12145 Mumbai Delhi Shatabdi
        List<Station> schedule12145 = Arrays.asList(
                new Station("MMCT", "Mumbai", "-", "06:45", "-", 0),
                new Station("ST", "Surat", "11:45", "11:55", "10 min", 386),
                new Station("BRC", "Vadodara", "14:55", "15:05", "10 min", 556),
                new Station("NDLS", "Delhi", "23:05", "-", "-", 1026)
        );
        List<TrainClass> classes12145 = Arrays.asList(
                new TrainClass("1A", 3372, 0, 2, 0, 2),
                new TrainClass("2A", 2407, 13, 5, 0, 6),
                new TrainClass("3A", 1432, 38, 10, 10, 20),
                new TrainClass("SL", 879, 98, 20, 7, 3)
        );
        trains.add(new Train("12145", "Mumbai Delhi Shatabdi", "MMCT", "NDLS", "00:15", "10:45", "23h 00m", classes12145, Arrays.asList("Tue", "Thu", "Sat"), schedule12145));

        // 12156 Pune Jaipur Rajdhani
        List<Station> schedule12156 = Arrays.asList(
                new Station("PUNE", "Pune", "-", "18:30", "-", 0),
                new Station("MMCT", "Mumbai", "20:30", "20:40", "10 min", 302),
                new Station("ADI", "Ahmedabad", "01:40", "01:50", "10 min", 663),
                new Station("JP", "Jaipur", "06:50", "-", "-", 1114)
        );
        List<TrainClass> classes12156 = Arrays.asList(
                new TrainClass("2A", 1808, 12, 5, 4, 10),
                new TrainClass("3A", 1157, 33, 10, 2, 20)
        );
        trains.add(new Train("12156", "Pune Jaipur Rajdhani", "PUNE", "JP", "07:45", "22:15", "12h 30m", classes12156, Arrays.asList("Daily"), schedule12156));

        // 12166 Hyderabad Delhi Rajdhani
        List<Station> schedule12166 = Arrays.asList(
                new Station("SC", "Hyderabad", "-", "22:15", "-", 0),
                new Station("NGP", "Nagpur", "00:15", "00:25", "10 min", 298),
                new Station("BPL", "Bhopal", "02:25", "02:35", "10 min", 468),
                new Station("NDLS", "Delhi", "10:35", "-", "-", 772)
        );
        List<TrainClass> classes12166 = Arrays.asList(
                new TrainClass("2A", 1921, 10, 5, 5, 6),
                new TrainClass("3A", 1079, 0, 10, 3, 10)
        );
        trains.add(new Train("12166", "Hyderabad Delhi Rajdhani", "SC", "NDLS", "21:00", "19:00", "20h 30m", classes12166, Arrays.asList("Daily"), schedule12166));

        // 12183 Mumbai Delhi Mail
        List<Station> schedule12183 = Arrays.asList(
                new Station("MMCT", "Mumbai", "-", "14:45", "-", 0),
                new Station("ADI", "Ahmedabad", "18:45", "18:55", "10 min", 174),
                new Station("JP", "Jaipur", "20:55", "21:05", "10 min", 425),
                new Station("NDLS", "Delhi", "02:05", "-", "-", 903)
        );
        List<TrainClass> classes12183 = Arrays.asList(
                new TrainClass("1A", 2788, 0, 2, 2, 5),
                new TrainClass("2A", 1706, 7, 5, 0, 0),
                new TrainClass("3A", 1088, 12, 10, 1, 6)
        );
        trains.add(new Train("12183", "Mumbai Delhi Mail", "MMCT", "NDLS", "01:15", "14:15", "25h 00m", classes12183, Arrays.asList("Daily"), schedule12183));

        // 12185 Kolkata Delhi Express
        List<Station> schedule12185 = Arrays.asList(
                new Station("HWH", "Kolkata", "-", "19:15", "-", 0),
                new Station("BSB", "Varanasi", "21:15", "21:25", "10 min", 301),
                new Station("LKO", "Lucknow", "02:25", "02:35", "10 min", 544),
                new Station("NDLS", "Delhi", "05:35", "-", "-", 799)
        );
        List<TrainClass> classes12185 = Arrays.asList(
                new TrainClass("1A", 3036, 1, 2, 2, 5),
                new TrainClass("2A", 2269, 9, 5, 5, 6),
                new TrainClass("3A", 1044, 28, 10, 3, 0)
        );
        trains.add(new Train("12185", "Kolkata Delhi Express", "HWH", "NDLS", "22:00", "10:15", "8h 30m", classes12185, Arrays.asList("Tue", "Thu", "Sat"), schedule12185));

        // 12202 Kota Chandigarh Superfast
        List<Station> schedule12202 = Arrays.asList(
                new Station("KOTA", "Kota", "-", "02:45", "-", 0),
                new Station("JP", "Jaipur", "04:45", "04:55", "10 min", 239),
                new Station("NDLS", "Delhi", "08:55", "09:05", "10 min", 513),
                new Station("CDG", "Chandigarh", "15:05", "-", "-", 749)
        );
        List<TrainClass> classes12202 = Arrays.asList(
                new TrainClass("2A", 1646, 1, 5, 2, 2),
                new TrainClass("3A", 1079, 10, 10, 7, 7),
                new TrainClass("SL", 984, 77, 20, 0, 28)
        );
        trains.add(new Train("12202", "Kota Chandigarh Superfast", "KOTA", "CDG", "22:30", "15:15", "5h 00m", classes12202, Arrays.asList("Tue", "Thu", "Sat"), schedule12202));

        // 12220 Kota Chandigarh Express
        List<Station> schedule12220 = Arrays.asList(
                new Station("KOTA", "Kota", "-", "05:45", "-", 0),
                new Station("JP", "Jaipur", "08:45", "08:55", "10 min", 341),
                new Station("NDLS", "Delhi", "13:55", "14:05", "10 min", 662),
                new Station("CDG", "Chandigarh", "19:05", "-", "-", 1017)
        );
        List<TrainClass> classes12220 = Arrays.asList(
                new TrainClass("1A", 3705, 1, 2, 1, 1),
                new TrainClass("2A", 2117, 2, 5, 5, 3),
                new TrainClass("3A", 1364, 5, 10, 6, 12)
        );
        trains.add(new Train("12220", "Kota Chandigarh Express", "KOTA", "CDG", "09:00", "11:30", "28h 00m", classes12220, Arrays.asList("Tue", "Thu", "Sat"), schedule12220));

        // 12224 Pune Jaipur Superfast
        List<Station> schedule12224 = Arrays.asList(
                new Station("PUNE", "Pune", "-", "05:30", "-", 0),
                new Station("MMCT", "Mumbai", "07:30", "07:40", "10 min", 376),
                new Station("ADI", "Ahmedabad", "11:40", "11:50", "10 min", 767),
                new Station("JP", "Jaipur", "16:50", "-", "-", 1161)
        );
        List<TrainClass> classes12224 = Arrays.asList(
                new TrainClass("1A", 3119, 2, 2, 0, 2),
                new TrainClass("2A", 1842, 0, 5, 5, 4),
                new TrainClass("3A", 1200, 14, 10, 4, 9),
                new TrainClass("SL", 417, 62, 20, 6, 3)
        );
        trains.add(new Train("12224", "Pune Jaipur Superfast", "PUNE", "JP", "15:00", "23:30", "28h 15m", classes12224, Arrays.asList("Daily"), schedule12224));

        // 12228 Chennai Mumbai Mail
        List<Station> schedule12228 = Arrays.asList(
                new Station("MAS", "Chennai", "-", "23:30", "-", 0),
                new Station("SBC", "Bengaluru", "02:30", "02:40", "10 min", 183),
                new Station("MMCT", "Mumbai", "08:40", "-", "-", 467)
        );
        List<TrainClass> classes12228 = Arrays.asList(
                new TrainClass("2A", 1559, 14, 5, 5, 10),
                new TrainClass("3A", 1433, 4, 10, 0, 2),
                new TrainClass("SL", 603, 23, 20, 0, 2)
        );
        trains.add(new Train("12228", "Chennai Mumbai Mail", "MAS", "MMCT", "03:30", "23:45", "27h 30m", classes12228, Arrays.asList("Tue", "Thu", "Sat"), schedule12228));

        // 12229 Guwahati Delhi Duronto
        List<Station> schedule12229 = Arrays.asList(
                new Station("GHY", "Guwahati", "-", "11:15", "-", 0),
                new Station("PNBE", "Patna", "16:15", "16:25", "10 min", 332),
                new Station("BSB", "Varanasi", "21:25", "21:35", "10 min", 732),
                new Station("NDLS", "Delhi", "03:35", "-", "-", 978)
        );
        List<TrainClass> classes12229 = Arrays.asList(
                new TrainClass("1A", 3227, 4, 2, 2, 4),
                new TrainClass("2A", 1741, 4, 5, 2, 7),
                new TrainClass("3A", 1218, 21, 10, 4, 1),
                new TrainClass("SL", 578, 82, 20, 14, 14)
        );
        trains.add(new Train("12229", "Guwahati Delhi Duronto", "GHY", "NDLS", "10:30", "01:30", "7h 00m", classes12229, Arrays.asList("Tue", "Thu", "Sat"), schedule12229));

        // 12247 Goa Ahmedabad Express
        List<Station> schedule12247 = Arrays.asList(
                new Station("MAO", "Goa", "-", "13:15", "-", 0),
                new Station("MMCT", "Mumbai", "16:15", "16:25", "10 min", 243),
                new Station("ST", "Surat", "18:25", "18:35", "10 min", 409),
                new Station("ADI", "Ahmedabad", "00:35", "-", "-", 781)
        );
        List<TrainClass> classes12247 = Arrays.asList(
                new TrainClass("2A", 1563, 15, 5, 2, 1),
                new TrainClass("3A", 1291, 16, 10, 10, 0)
        );
        trains.add(new Train("12247", "Goa Ahmedabad Express", "MAO", "ADI", "02:15", "08:00", "24h 45m", classes12247, Arrays.asList("Mon", "Wed", "Fri"), schedule12247));

        // 12258 Delhi Kolkata Rajdhani
        List<Station> schedule12258 = Arrays.asList(
                new Station("NDLS", "Delhi", "-", "19:00", "-", 0),
                new Station("CNB", "Kanpur", "23:00", "23:10", "10 min", 333),
                new Station("PNBE", "Patna", "01:10", "01:20", "10 min", 674),
                new Station("HWH", "Kolkata", "07:20", "-", "-", 923)
        );
        List<TrainClass> classes12258 = Arrays.asList(
                new TrainClass("2A", 1946, 8, 5, 4, 0),
                new TrainClass("3A", 1022, 9, 10, 8, 9),
                new TrainClass("SL", 766, 24, 20, 2, 25)
        );
        trains.add(new Train("12258", "Delhi Kolkata Rajdhani", "NDLS", "HWH", "10:45", "04:00", "5h 15m", classes12258, Arrays.asList("Daily"), schedule12258));

        // 12277 Delhi Kolkata Superfast
        List<Station> schedule12277 = Arrays.asList(
                new Station("NDLS", "Delhi", "-", "23:15", "-", 0),
                new Station("CNB", "Kanpur", "04:15", "04:25", "10 min", 342),
                new Station("PNBE", "Patna", "09:25", "09:35", "10 min", 667),
                new Station("HWH", "Kolkata", "16:35", "-", "-", 925)
        );
        List<TrainClass> classes12277 = Arrays.asList(
                new TrainClass("2A", 2168, 10, 5, 2, 8),
                new TrainClass("3A", 1254, 8, 10, 0, 3),
                new TrainClass("SL", 999, 63, 20, 10, 14)
        );
        trains.add(new Train("12277", "Delhi Kolkata Superfast", "NDLS", "HWH", "05:30", "11:30", "5h 30m", classes12277, Arrays.asList("Tue", "Thu", "Sat"), schedule12277));

        // 12285 Kota Chandigarh Shatabdi
        List<Station> schedule12285 = Arrays.asList(
                new Station("KOTA", "Kota", "-", "06:30", "-", 0),
                new Station("JP", "Jaipur", "11:30", "11:40", "10 min", 166),
                new Station("NDLS", "Delhi", "15:40", "15:50", "10 min", 354),
                new Station("CDG", "Chandigarh", "20:50", "-", "-", 732)
        );
        List<TrainClass> classes12285 = Arrays.asList(
                new TrainClass("1A", 2779, 1, 2, 1, 0),
                new TrainClass("2A", 1517, 12, 5, 2, 4),
                new TrainClass("3A", 1451, 32, 10, 2, 20)
        );
        trains.add(new Train("12285", "Kota Chandigarh Shatabdi", "KOTA", "CDG", "04:00", "07:00", "12h 30m", classes12285, Arrays.asList("Mon", "Wed", "Fri"), schedule12285));

        // 12300 Guwahati Delhi Rajdhani
        List<Station> schedule12300 = Arrays.asList(
                new Station("GHY", "Guwahati", "-", "13:45", "-", 0),
                new Station("PNBE", "Patna", "15:45", "15:55", "10 min", 250),
                new Station("BSB", "Varanasi", "19:55", "20:05", "10 min", 476),
                new Station("NDLS", "Delhi", "02:05", "-", "-", 693)
        );
        List<TrainClass> classes12300 = Arrays.asList(
                new TrainClass("1A", 2821, 1, 2, 2, 4),
                new TrainClass("2A", 2085, 6, 5, 4, 4),
                new TrainClass("3A", 1324, 7, 10, 8, 16)
        );
        trains.add(new Train("12300", "Guwahati Delhi Rajdhani", "GHY", "NDLS", "05:30", "14:15", "23h 30m", classes12300, Arrays.asList("Tue", "Thu", "Sat"), schedule12300));

        // 12306 Hyderabad Delhi Mail
        List<Station> schedule12306 = Arrays.asList(
                new Station("SC", "Hyderabad", "-", "17:15", "-", 0),
                new Station("NGP", "Nagpur", "19:15", "19:25", "10 min", 157),
                new Station("BPL", "Bhopal", "00:25", "00:35", "10 min", 486),
                new Station("NDLS", "Delhi", "04:35", "-", "-", 727)
        );
        List<TrainClass> classes12306 = Arrays.asList(
                new TrainClass("2A", 1957, 3, 5, 5, 9),
                new TrainClass("3A", 1110, 0, 10, 2, 13),
                new TrainClass("SL", 643, 100, 20, 7, 27)
        );
        trains.add(new Train("12306", "Hyderabad Delhi Mail", "SC", "NDLS", "20:45", "02:00", "29h 15m", classes12306, Arrays.asList("Tue", "Thu", "Sat"), schedule12306));

        // 12325 Mumbai Delhi Shatabdi
        List<Station> schedule12325 = Arrays.asList(
                new Station("MMCT", "Mumbai", "-", "11:15", "-", 0),
                new Station("ADI", "Ahmedabad", "16:15", "16:25", "10 min", 162),
                new Station("JP", "Jaipur", "19:25", "19:35", "10 min", 411),
                new Station("NDLS", "Delhi", "23:35", "-", "-", 795)
        );
        List<TrainClass> classes12325 = Arrays.asList(
                new TrainClass("2A", 2346, 14, 5, 0, 7),
                new TrainClass("3A", 1314, 19, 10, 0, 2)
        );
        trains.add(new Train("12325", "Mumbai Delhi Shatabdi", "MMCT", "NDLS", "05:00", "09:30", "26h 45m", classes12325, Arrays.asList("Mon", "Wed", "Fri"), schedule12325));

        // 12340 Goa Ahmedabad Rajdhani
        List<Station> schedule12340 = Arrays.asList(
                new Station("MAO", "Goa", "-", "16:45", "-", 0),
                new Station("MMCT", "Mumbai", "20:45", "20:55", "10 min", 327),
                new Station("ST", "Surat", "00:55", "01:05", "10 min", 533),
                new Station("ADI", "Ahmedabad", "04:05", "-", "-", 794)
        );
        List<TrainClass> classes12340 = Arrays.asList(
                new TrainClass("1A", 3748, 4, 2, 1, 3),
                new TrainClass("2A", 2500, 13, 5, 5, 7),
                new TrainClass("3A", 1206, 22, 10, 8, 3)
        );
        trains.add(new Train("12340", "Goa Ahmedabad Rajdhani", "MAO", "ADI", "14:00", "05:15", "27h 45m", classes12340, Arrays.asList("Mon", "Wed", "Fri"), schedule12340));

        // 12352 Guwahati Delhi Express
        List<Station> schedule12352 = Arrays.asList(
                new Station("GHY", "Guwahati", "-", "10:30", "-", 0),
                new Station("PNBE", "Patna", "12:30", "12:40", "10 min", 235),
                new Station("BSB", "Varanasi", "14:40", "14:50", "10 min", 457),
                new Station("NDLS", "Delhi", "22:50", "-", "-", 664)
        );
        List<TrainClass> classes12352 = Arrays.asList(
                new TrainClass("2A", 2023, 15, 5, 3, 6),
                new TrainClass("3A", 1073, 20, 10, 7, 7)
        );
        trains.add(new Train("12352", "Guwahati Delhi Express", "GHY", "NDLS", "15:30", "01:15", "11h 00m", classes12352, Arrays.asList("Daily"), schedule12352));

        // 12359 Bengaluru Delhi Rajdhani
        List<Station> schedule12359 = Arrays.asList(
                new Station("SBC", "Bengaluru", "-", "21:45", "-", 0),
                new Station("SC", "Hyderabad", "00:45", "00:55", "10 min", 153),
                new Station("NGP", "Nagpur", "05:55", "06:05", "10 min", 410),
                new Station("NDLS", "Delhi", "09:05", "-", "-", 710)
        );
        List<TrainClass> classes12359 = Arrays.asList(
                new TrainClass("2A", 2325, 1, 5, 5, 2),
                new TrainClass("3A", 1383, 17, 10, 4, 18)
        );
        trains.add(new Train("12359", "Bengaluru Delhi Rajdhani", "SBC", "NDLS", "15:45", "03:15", "15h 00m", classes12359, Arrays.asList("Daily"), schedule12359));

        // 12374 Ranchi Delhi Express
        List<Station> schedule12374 = Arrays.asList(
                new Station("RNC", "Ranchi", "-", "00:45", "-", 0),
                new Station("PNBE", "Patna", "04:45", "04:55", "10 min", 187),
                new Station("LKO", "Lucknow", "08:55", "09:05", "10 min", 439),
                new Station("NDLS", "Delhi", "14:05", "-", "-", 707)
        );
        List<TrainClass> classes12374 = Arrays.asList(
                new TrainClass("1A", 3637, 3, 2, 1, 2),
                new TrainClass("2A", 2173, 12, 5, 2, 2),
                new TrainClass("3A", 1106, 27, 10, 4, 16),
                new TrainClass("SL", 874, 70, 20, 14, 12)
        );
        trains.add(new Train("12374", "Ranchi Delhi Express", "RNC", "NDLS", "13:45", "13:00", "6h 15m", classes12374, Arrays.asList("Mon", "Wed", "Fri"), schedule12374));

        // 12386 Mumbai Delhi Shatabdi
        List<Station> schedule12386 = Arrays.asList(
                new Station("MMCT", "Mumbai", "-", "11:30", "-", 0),
                new Station("ADI", "Ahmedabad", "13:30", "13:40", "10 min", 153),
                new Station("JP", "Jaipur", "15:40", "15:50", "10 min", 452),
                new Station("NDLS", "Delhi", "18:50", "-", "-", 783)
        );
        List<TrainClass> classes12386 = Arrays.asList(
                new TrainClass("1A", 2806, 3, 2, 0, 0),
                new TrainClass("2A", 1581, 7, 5, 2, 5),
                new TrainClass("3A", 1004, 22, 10, 7, 15)
        );
        trains.add(new Train("12386", "Mumbai Delhi Shatabdi", "MMCT", "NDLS", "21:00", "11:45", "13h 15m", classes12386, Arrays.asList("Tue", "Thu", "Sat"), schedule12386));

        // 12396 Chennai Mumbai Shatabdi
        List<Station> schedule12396 = Arrays.asList(
                new Station("MAS", "Chennai", "-", "05:00", "-", 0),
                new Station("SBC", "Bengaluru", "07:00", "07:10", "10 min", 390),
                new Station("MMCT", "Mumbai", "12:10", "-", "-", 740)
        );
        List<TrainClass> classes12396 = Arrays.asList(
                new TrainClass("2A", 1867, 14, 5, 0, 3),
                new TrainClass("3A", 1429, 25, 10, 9, 5),
                new TrainClass("SL", 801, 64, 20, 20, 6)
        );
        trains.add(new Train("12396", "Chennai Mumbai Shatabdi", "MAS", "MMCT", "23:15", "15:15", "26h 45m", classes12396, Arrays.asList("Daily"), schedule12396));

        // 12407 Mumbai Delhi Mail
        List<Station> schedule12407 = Arrays.asList(
                new Station("MMCT", "Mumbai", "-", "07:45", "-", 0),
                new Station("ST", "Surat", "12:45", "12:55", "10 min", 150),
                new Station("BRC", "Vadodara", "15:55", "16:05", "10 min", 529),
                new Station("NDLS", "Delhi", "23:05", "-", "-", 932)
        );
        List<TrainClass> classes12407 = Arrays.asList(
                new TrainClass("1A", 3519, 5, 2, 0, 0),
                new TrainClass("2A", 1955, 0, 5, 3, 6),
                new TrainClass("3A", 1180, 11, 10, 1, 0)
        );
        trains.add(new Train("12407", "Mumbai Delhi Mail", "MMCT", "NDLS", "09:15", "14:15", "28h 00m", classes12407, Arrays.asList("Daily"), schedule12407));

        // 12416 Ranchi Delhi Superfast
        List<Station> schedule12416 = Arrays.asList(
                new Station("RNC", "Ranchi", "-", "22:45", "-", 0),
                new Station("PNBE", "Patna", "01:45", "01:55", "10 min", 337),
                new Station("LKO", "Lucknow", "03:55", "04:05", "10 min", 687),
                new Station("NDLS", "Delhi", "11:05", "-", "-", 912)
        );
        List<TrainClass> classes12416 = Arrays.asList(
                new TrainClass("1A", 3255, 0, 2, 1, 4),
                new TrainClass("2A", 1518, 7, 5, 0, 0),
                new TrainClass("3A", 1433, 32, 10, 8, 10),
                new TrainClass("SL", 861, 38, 20, 5, 12)
        );
        trains.add(new Train("12416", "Ranchi Delhi Superfast", "RNC", "NDLS", "11:30", "15:15", "28h 45m", classes12416, Arrays.asList("Daily"), schedule12416));

        // 12421 Ahmedabad Pune Express
        List<Station> schedule12421 = Arrays.asList(
                new Station("ADI", "Ahmedabad", "-", "18:45", "-", 0),
                new Station("ST", "Surat", "23:45", "23:55", "10 min", 186),
                new Station("MMCT", "Mumbai", "04:55", "05:05", "10 min", 526),
                new Station("PUNE", "Pune", "10:05", "-", "-", 772)
        );
        List<TrainClass> classes12421 = Arrays.asList(
                new TrainClass("1A", 3626, 5, 2, 1, 0),
                new TrainClass("2A", 2301, 1, 5, 2, 5),
                new TrainClass("3A", 1062, 25, 10, 7, 9),
                new TrainClass("SL", 625, 81, 20, 10, 12)
        );
        trains.add(new Train("12421", "Ahmedabad Pune Express", "ADI", "PUNE", "08:15", "12:30", "23h 15m", classes12421, Arrays.asList("Tue", "Thu", "Sat"), schedule12421));

    }

    public List<Train> getAllTrains() {
        return trains;
    }

    public Train getTrainByNumber(String trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber().equals(trainNumber) || train.getTrainName().equalsIgnoreCase(trainNumber)) {
                return train;
            }
        }
        return null;
    }

    private boolean isMatch(String input, String code, String name) {
        if (input == null || input.isEmpty()) return false;
        String in = input.toLowerCase();
        String c = code != null ? code.toLowerCase() : "";
        String n = name != null ? name.toLowerCase() : "";
        
        boolean matchC = !c.isEmpty() && (in.contains(c) || c.contains(in));
        boolean matchN = !n.isEmpty() && (in.contains(n) || n.contains(in));
        
        return matchC || matchN;
    }

    public List<Train> searchTrains(String source, String destination) {
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            int sourceIdx = -1;
            int destIdx = -1;
            
            for (int i = 0; i < train.getSchedule().size(); i++) {
                Station s = train.getSchedule().get(i);
                if (sourceIdx == -1 && isMatch(source, s.getCode(), s.getName())) {
                    sourceIdx = i;
                }
                if (sourceIdx != -1 && i > sourceIdx && isMatch(destination, s.getCode(), s.getName())) {
                    destIdx = i;
                    break;
                }
            }
            
            boolean fallbackSource = isMatch(source, train.getSource(), "");
            boolean fallbackDest = isMatch(destination, train.getDestination(), "");
            
            if ((sourceIdx != -1 && destIdx != -1) || (fallbackSource && fallbackDest)) {
                result.add(train);
            }
        }
        return result;
    }
    
    // Connecting routes logic
    public List<List<Train>> searchConnectingRoutes(String source, String destination) {
        List<List<Train>> connectingRoutes = new ArrayList<>();
        
        for (Train train1 : trains) {
            int sourceIdx = -1;
            for (int i = 0; i < train1.getSchedule().size(); i++) {
                if (isMatch(source, train1.getSchedule().get(i).getCode(), train1.getSchedule().get(i).getName())) {
                    sourceIdx = i;
                    break;
                }
            }
            
            if (sourceIdx != -1 || isMatch(source, train1.getSource(), "")) {
                int startLoop = sourceIdx != -1 ? sourceIdx + 1 : 0;
                for (int i = startLoop; i < train1.getSchedule().size(); i++) {
                    Station midStation = train1.getSchedule().get(i);
                    
                    for (Train train2 : trains) {
                        if (train1.getTrainNumber().equals(train2.getTrainNumber())) continue;
                        
                        int midIdx2 = -1;
                        int destIdx2 = -1;
                        
                        for (int j = 0; j < train2.getSchedule().size(); j++) {
                            Station s2 = train2.getSchedule().get(j);
                            if (midIdx2 == -1 && isMatch(midStation.getCode(), s2.getCode(), s2.getName())) {
                                midIdx2 = j;
                            }
                            if (midIdx2 != -1 && j > midIdx2 && isMatch(destination, s2.getCode(), s2.getName())) {
                                destIdx2 = j;
                                break;
                            }
                        }
                        
                        if (midIdx2 != -1 && destIdx2 != -1) {
                            // Avoid duplicate routes
                            boolean exists = false;
                            for (List<Train> r : connectingRoutes) {
                                if (r.get(0).getTrainNumber().equals(train1.getTrainNumber()) && r.get(1).getTrainNumber().equals(train2.getTrainNumber())) {
                                    exists = true;
                                }
                            }
                            if (!exists) {
                                List<Train> route = new ArrayList<>();
                                route.add(train1);
                                route.add(train2);
                                connectingRoutes.add(route);
                                
                                if (connectingRoutes.size() >= 5) {
                                    return connectingRoutes;
                                }
                            }
                        }
                    }
                }
            }
        }
        return connectingRoutes;
    }
}
