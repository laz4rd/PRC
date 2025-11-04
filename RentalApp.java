import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Simple rental manager: Cars/Bikes.
 * - Prevents overlapping rentals for the same vehicle
 * - Computes base fee and late fee on return
 *
 * Date/time input format: yyyy-MM-dd HH:mm  (e.g. 2025-11-03 18:30)
 */
public class RentalApp {
    // Simple rate settings (change as needed)
    static class Rates {
        static final double CAR_PER_HOUR = 200.0;
        static final double BIKE_PER_HOUR = 100.0;
        // Additional late multiplier: if 0.5, late hourly cost = base * 0.5 (i.e., +50%)
        static final double LATE_EXTRA_MULTIPLIER = 0.5;
    }

    // Vehicle abstraction
    static abstract class Vehicle {
        final String id;
        final String model;
        Vehicle(String id, String model) { this.id = id; this.model = model; }
        abstract double hourlyRate();
        public String toString() { return String.format("%s [%s] (rate/hr ₹%.2f)", model, id, hourlyRate()); }
    }

    static class Car extends Vehicle {
        Car(String id, String model) { super(id, model); }
        double hourlyRate() { return Rates.CAR_PER_HOUR; }
    }
    static class Bike extends Vehicle {
        Bike(String id, String model) { super(id, model); }
        double hourlyRate() { return Rates.BIKE_PER_HOUR; }
    }

    // Rental record
    static class Rental {
        final String rentalId;
        final Vehicle vehicle;
        final String renterName;
        final LocalDateTime start;
        final LocalDateTime scheduledEnd;
        LocalDateTime actualReturn; // null if not returned yet
        Rental(String rentalId, Vehicle v, String renterName, LocalDateTime start, LocalDateTime scheduledEnd) {
            this.rentalId = rentalId;
            this.vehicle = v;
            this.renterName = renterName;
            this.start = start;
            this.scheduledEnd = scheduledEnd;
            this.actualReturn = null;
        }

        boolean isActive() { return actualReturn == null; }

        // compute base fee based on scheduled period (hours rounded up)
        double computeBaseFee() {
            long hours = ceilHoursBetween(start, scheduledEnd);
            return hours * vehicle.hourlyRate();
        }

        // compute fee at actual return time (base for actual duration)
        double computeFeeAtReturn() {
            LocalDateTime end = actualReturn != null ? actualReturn : scheduledEnd;
            long hours = ceilHoursBetween(start, end);
            return hours * vehicle.hourlyRate();
        }

        // compute late fee if returned after scheduledEnd
        double computeLateFee() {
            if (actualReturn == null) return 0;
            if (!actualReturn.isAfter(scheduledEnd)) return 0;
            long lateHours = ceilHoursBetween(scheduledEnd, actualReturn);
            double extraPerHour = vehicle.hourlyRate() * Rates.LATE_EXTRA_MULTIPLIER;
            return lateHours * extraPerHour;
        }

        static long ceilHoursBetween(LocalDateTime a, LocalDateTime b) {
            if (!b.isAfter(a)) return 0;
            Duration d = Duration.between(a, b);
            long seconds = d.getSeconds();
            long hours = seconds / 3600;
            if (seconds % 3600 != 0) hours++; // ceil
            return hours;
        }

        public String toString() {
            String status = isActive() ? "ACTIVE" : "RETURNED";
            String scheduled = scheduledEnd.format(RentalApp.FMT);
            String actual = actualReturn == null ? "-" : actualReturn.format(RentalApp.FMT);
            return String.format("Rental[%s] %s by %s | vehicle=%s | start=%s | scheduledEnd=%s | actualReturn=%s | %s",
                    rentalId, vehicle.model, renterName, vehicle.id, start.format(RentalApp.FMT), scheduled, actual, status);
        }
    }

    // Manager
    static class RentalManager {
        private final Map<String, Vehicle> vehicles = new HashMap<>();
        private final Map<String, Rental> rentals = new HashMap<>();
        private int rentalSeq = 1;

        void addVehicle(Vehicle v) { vehicles.put(v.id, v); }

        Collection<Vehicle> listVehicles() { return vehicles.values(); }

        Collection<Rental> listRentals() { return rentals.values(); }

        // Check overlap for the same vehicle: returns true if overlap exists
        boolean hasOverlap(String vehicleId, LocalDateTime reqStart, LocalDateTime reqEnd) {
            for (Rental r : rentals.values()) {
                if (!r.vehicle.id.equals(vehicleId)) continue;
                // consider scheduled window if not returned yet, or scheduled window even if returned (we disallow overlapping scheduled periods)
                LocalDateTime existingStart = r.start;
                LocalDateTime existingEnd = r.scheduledEnd;
                // Overlap condition: reqStart < existingEnd && reqEnd > existingStart
                if (reqStart.isBefore(existingEnd) && reqEnd.isAfter(existingStart)) {
                    return true;
                }
            }
            return false;
        }

        // Create rental if no conflict; returns rental ID or null if conflict
        String createRental(String vehicleId, String renterName, LocalDateTime start, LocalDateTime scheduledEnd) {
            Vehicle v = vehicles.get(vehicleId);
            if (v == null) throw new IllegalArgumentException("No vehicle with id " + vehicleId);
            if (!start.isBefore(scheduledEnd)) throw new IllegalArgumentException("Start must be before scheduled end.");
            if (hasOverlap(vehicleId, start, scheduledEnd)) return null;
            String rid = String.format("R%04d", rentalSeq++);
            Rental r = new Rental(rid, v, renterName, start, scheduledEnd);
            rentals.put(rid, r);
            return rid;
        }

        // Return rental (record actual return time), compute totals
        Optional<Map<String, Double>> returnRental(String rentalId, LocalDateTime actualReturnTime) {
            Rental r = rentals.get(rentalId);
            if (r == null) return Optional.empty();
            if (!r.isActive()) return Optional.empty();
            if (actualReturnTime.isBefore(r.start)) return Optional.empty();
            r.actualReturn = actualReturnTime;
            double baseAtReturn = r.computeFeeAtReturn();
            double lateFee = r.computeLateFee();
            double total = baseAtReturn + lateFee;
            Map<String, Double> res = new HashMap<>();
            res.put("baseAtReturn", baseAtReturn);
            res.put("lateFee", lateFee);
            res.put("total", total);
            return Optional.of(res);
        }

        Optional<Rental> findRental(String rentalId) {
            return Optional.ofNullable(rentals.get(rentalId));
        }
    }

    // Date/time format
    static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalManager mgr = new RentalManager();

        // Prepopulate some vehicles
        mgr.addVehicle(new Car("CAR001", "Toyota Altis"));
        mgr.addVehicle(new Car("CAR002", "Hyundai Creta"));
        mgr.addVehicle(new Bike("BIKE001", "Royal Enfield"));
        mgr.addVehicle(new Bike("BIKE002", "Honda CB Shine"));

        System.out.println("=== Simple Rental System ===");
        String cmd;
        outer:
        while (true) {
            System.out.println("\nOptions: listv | listr | rent | return | info <rentalId> | quit");
            System.out.print("> ");
            cmd = sc.nextLine().trim();
            if (cmd.equalsIgnoreCase("listv")) {
                System.out.println("Vehicles:");
                for (Vehicle v : mgr.listVehicles()) System.out.println("  " + v);
            } else if (cmd.equalsIgnoreCase("listr")) {
                System.out.println("Rentals:");
                for (Rental r : mgr.listRentals()) System.out.println("  " + r);
            } else if (cmd.equalsIgnoreCase("rent")) {
                try {
                    System.out.print("Vehicle ID: ");
                    String vid = sc.nextLine().trim();
                    System.out.print("Renter name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Start (yyyy-MM-dd HH:mm): ");
                    LocalDateTime start = LocalDateTime.parse(sc.nextLine().trim(), FMT);
                    System.out.print("Scheduled end (yyyy-MM-dd HH:mm): ");
                    LocalDateTime end = LocalDateTime.parse(sc.nextLine().trim(), FMT);

                    if (!start.isBefore(end)) {
                        System.out.println("Error: start must be before scheduled end.");
                        continue;
                    }

                    if (mgr.hasOverlap(vid, start, end)) {
                        System.out.println("Cannot rent: overlapping booking exists for that vehicle.");
                        continue;
                    }

                    String rid = mgr.createRental(vid, name, start, end);
                    if (rid == null) {
                        System.out.println("Failed to create rental (conflict).");
                    } else {
                        System.out.println("Rental created with ID: " + rid);
                        // Show scheduled base fee
                        Rental r = mgr.findRental(rid).get();
                        System.out.printf("Scheduled base fee (based on scheduled period): ₹%.2f%n", r.computeBaseFee());
                    }
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            } else if (cmd.equalsIgnoreCase("return")) {
                try {
                    System.out.print("Rental ID to return: ");
                    String rid = sc.nextLine().trim();
                    Rental r = mgr.findRental(rid).orElse(null);
                    if (r == null) {
                        System.out.println("No such rental.");
                        continue;
                    }
                    if (!r.isActive()) {
                        System.out.println("Already returned.");
                        continue;
                    }
                    System.out.print("Actual return time (yyyy-MM-dd HH:mm) or press Enter for now: ");
                    String line = sc.nextLine().trim();
                    LocalDateTime actual;
                    if (line.isEmpty()) actual = LocalDateTime.now();
                    else actual = LocalDateTime.parse(line, FMT);

                    Optional<Map<String, Double>> res = mgr.returnRental(rid, actual);
                    if (res.isEmpty()) {
                        System.out.println("Failed to return rental. Check times.");
                        continue;
                    }
                    Map<String, Double> out = res.get();
                    System.out.printf("Base (for actual duration): ₹%.2f%n", out.get("baseAtReturn"));
                    System.out.printf("Late fee: ₹%.2f%n", out.get("lateFee"));
                    System.out.printf("TOTAL to collect: ₹%.2f%n", out.get("total"));
                } catch (Exception ex) {
                    System.out.println("Error while returning: " + ex.getMessage());
                }
            } else if (cmd.startsWith("info")) {
                String[] parts = cmd.split("\\s+");
                if (parts.length < 2) { System.out.println("Usage: info <rentalId>"); continue; }
                String rid = parts[1].trim();
                Optional<Rental> r = mgr.findRental(rid);
                if (r.isEmpty()) { System.out.println("No such rental."); continue; }
                System.out.println(r.get());
            } else if (cmd.equalsIgnoreCase("quit")) {
                break outer;
            } else {
                System.out.println("Unknown command.");
            }
        }

        System.out.println("Exiting. Bye!");
        sc.close();
    }
}
