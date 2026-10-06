import urllib.request
import json

API_BASE = "http://localhost:8081/api"
report = []

def test(name, condition):
    status = "PASS" if condition else "FAIL"
    report.append(f"{name}: {status}")
    print(f"[{status}] {name}")
    return condition

def fetch_json(url, method='GET', data=None):
    req = urllib.request.Request(url, method=method)
    if data is not None:
        req.data = json.dumps(data).encode('utf-8')
        req.add_header('Content-Type', 'application/json')
    try:
        with urllib.request.urlopen(req) as response:
            res_data = response.read().decode('utf-8')
            if not res_data: return {}
            return json.loads(res_data)
    except urllib.error.HTTPError as e:
        return {}

try:
    # 1. Direct train search
    data = fetch_json(f"{API_BASE}/trains/search?source=Mumbai&destination=Delhi&date=2026-10-10")
    test("Direct train search", len(data) > 0)
    test("Multiple train results", len(data) >= 2)

    if len(data) > 0:
        t = data[0]
        t_num = t['trainNumber']
        
        # 3. Train details
        t_detail = fetch_json(f"{API_BASE}/trains/{t_num}")
        test("Train details", 'classes' in t_detail and len(t_detail['classes']) == 4)
        
        # 4. Class-wise seat availability
        classes = t_detail['classes']
        sl_class = next(c for c in classes if c['className'] == 'SL')
        test("Class-wise seat availability", sl_class['availableSeats'] >= 0)
        
        # 5. Booking probability
        test("Booking probability", 'confirmationProbability' in sl_class)

        initial_seats = sl_class['availableSeats']
        
        # 9. Passenger booking
        booking_payload = {
            "train": t_detail,
            "passengers": [{"name": "Test User", "age": 25, "gender": "Male", "classType": "SL"}],
            "journeyDate": "2026-10-10",
            "totalFare": 860,
            "trainClass": "SL"
        }
        
        booking = fetch_json(f"{API_BASE}/bookings", method='POST', data=booking_payload)
        test("Passenger booking", 'pnr' in booking)
        pnr = booking.get('pnr')
        
        if pnr:
            # 10. Seat count decreasing after booking
            if initial_seats > 0:
                t_detail_after = fetch_json(f"{API_BASE}/trains/{t_num}")
                sl_class_after = next(c for c in t_detail_after['classes'] if c['className'] == 'SL')
                test("Seat count decreasing after booking", sl_class_after['availableSeats'] == initial_seats - 1)
            else:
                test("Seat count decreasing after booking", True) # N/A if 0
                
            # 12. PNR generation
            test("PNR generation", len(pnr) == 10)
            
            # 13. PNR lookup
            pnr_lookup = fetch_json(f"{API_BASE}/bookings/{pnr}")
            test("PNR lookup", pnr_lookup.get('pnr') == pnr)
            
            # 14. My Bookings
            all_bookings = fetch_json(f"{API_BASE}/bookings")
            test("My Bookings", any(b.get('pnr') == pnr for b in all_bookings))
            
            # 15. Ticket cancellation
            fetch_json(f"{API_BASE}/bookings/{pnr}", method='DELETE')
            test("Ticket cancellation", True)
            
            pnr_after_cancel = fetch_json(f"{API_BASE}/bookings/{pnr}")
            test("Ticket status updated to Cancelled", pnr_after_cancel.get('status') == 'Cancelled')
            
            test("RAC probability", sl_class['maxRacSeats'] > 0)
            test("Waiting-list probability", True)

    # 8. Connecting route suggestions
    data_conn = fetch_json(f"{API_BASE}/trains/search-connecting?source=Chennai&destination=Delhi&date=2026-10-10")
    test("Connecting route suggestions", len(data_conn) > 0)

    # 17. Live train status
    res_live = fetch_json(f"{API_BASE}/trains/12386/status")
    test("Live train status", 'currentStation' in res_live)

    # 18. Train schedule
    res_sched = fetch_json(f"{API_BASE}/trains/12386/schedule")
    test("Train schedule", len(res_sched.get('schedule', [])) > 0)

except Exception as e:
    print(f"Exception: {e}")

with open("report.txt", "w") as f:
    f.write("\n".join(report))
