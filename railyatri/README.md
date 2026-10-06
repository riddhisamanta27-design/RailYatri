# RailYatri - Railway Ticket Booking Web Application

RailYatri is a student project demonstrating a full-stack railway ticket booking web application. It features a responsive UI inspired by modern travel apps, combined with a beginner-friendly Java Spring Boot backend.

## 🚀 Features

- Search for trains between source and destination
- View Train Details (Schedule, Fares, Duration)
- View Connecting Routes if no direct train is available
- Multi-step booking flow (Passenger Details -> Payment -> Confirmation)
- Simulate payments and generate dynamic PNRs
- Track PNR status
- Live Train Status (Simulated)
- Check Train Schedule
- Manage Bookings (Upcoming, Cancelled)
- Responsive Mobile-First UI design

## 🛠️ Technology Stack

- **Frontend:** HTML5, CSS3, Vanilla JavaScript (No heavy frameworks used for simplicity)
- **Backend:** Java, Spring Boot (REST APIs)
- **Database/Storage:** In-memory Java Collections (ArrayList, HashMap, Queue) for simplicity and beginner-friendliness as per project constraints.

## 📂 Project Structure

```
railyatri/
├── backend/
│   ├── src/main/java/com/railyatri/
│   │   ├── model/         # Java model classes (Train, Passenger, Booking, etc.)
│   │   ├── controller/    # REST API endpoints
│   │   ├── service/       # Business logic and In-memory Data Structures
│   │   └── config/        # CORS configuration
│   └── pom.xml
└── frontend/
    ├── index.html         # Home / Search Train
    ├── trains.html        # Train Results
    ├── train-details.html # Train Details
    ├── route.html         # Connecting Routes
    ├── passenger.html     # Passenger entry form
    ├── payment.html       # Payment gateway simulation
    ├── confirmation.html  # Booking Ticket / PNR Generation
    ├── pnr.html           # PNR Status checker
    ├── live-status.html   # Simulated Live Train Status
    ├── schedule.html      # Train Timetable
    ├── bookings.html      # My Bookings dashboard
    ├── profile.html       # User Profile
    ├── css/style.css      # Core Stylesheet
    └── js/app.js          # Core JavaScript utility
```

## ⚙️ How to Run

### Backend (Spring Boot)
1. Ensure you have Java 17+ and Maven installed.
2. Open a terminal and navigate to the `backend` directory.
3. Run the following command:
   ```bash
   mvn clean spring-boot:run
   ```
4. The backend will start on `http://localhost:8081` (Port 8081 is configured in `application.properties`).

### Frontend
1. The frontend uses plain HTML/CSS/JS and does not require a complex build system.
2. Simply open `index.html` in your web browser, or serve it using any simple static web server (like VS Code Live Server or Python `http.server`).
3. Make sure the backend is running before searching for trains.

## 🧬 Data Structures Used (Java Backend)

To keep the logic easy to explain in a college viva, complex databases were omitted in favor of core Java Data Structures:

- **`ArrayList<Train>`**: Used in `TrainService.java` to store and iterate over available trains. Perfect for sequential search when matching `source` and `destination`.
- **`ArrayList<Passenger>` & `ArrayList<Station>`**: Used within `Booking` and `Train` models to maintain ordered lists of travellers and scheduled stops.
- **`HashMap<String, Booking>`**: Used in `BookingService.java`. The `PNR` string serves as the unique key, allowing O(1) instantaneous lookup when users check their PNR status.
- **`Queue<Passenger>` (LinkedList)**: Demonstrated conceptually in `BookingService` for handling waiting-list passengers on a first-come, first-served basis.

## 🧳 The Booking Flow

1. **Search**: User inputs Source, Destination, Date, and Class in `index.html`.
2. **Select**: API fetches matches in `trains.html`. User views details and selects a train.
3. **Passengers**: User fills passenger details in `passenger.html` (Local validations applied).
4. **Payment**: Details are summarized in `payment.html`. Simulates processing with a loader.
5. **Confirm**: The frontend POSTs payload to `/api/bookings`. The backend generates a random 10-digit PNR, assigns seats, and returns a `Booking` object.
6. **Result**: `confirmation.html` displays the final ticket details.
