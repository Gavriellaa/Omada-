public class Vehicle {
    private int id; // Το μοναδικό αναγνωριστικό του οχήματος
    private double capacity; // Η χωρητικότητα του οχήματος σε μονάδες
    private String vehicleType; // Ο τύπος του οχήματος (π.χ., Van, Truck)
    private double fuelConsumption; // Κατανάλωση καυσίμου ανά χιλιόμετρο

    /**
     * Κατασκευαστής για τη δημιουργία ενός οχήματος με βασικές παραμέτρους.
     * @param id το μοναδικό αναγνωριστικό του οχήματος
     * @param capacity η χωρητικότητα του οχήματος
     * @param vehicleType ο τύπος του οχήματος
     * @param fuelConsumption η κατανάλωση καυσίμου ανά χιλιόμετρο
     */
    public Vehicle(int id, double capacity, String vehicleType, double fuelConsumption) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        if (fuelConsumption < 0) {
            throw new IllegalArgumentException("Fuel consumption cannot be negative.");
        }

        this.id = id;
        this.capacity = capacity;
        this.vehicleType = vehicleType;
        this.fuelConsumption = fuelConsumption;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public double getCapacity() {
        return capacity;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        if (fuelConsumption < 0) {
            throw new IllegalArgumentException("Fuel consumption cannot be negative.");
        }
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Υπολογίζει την κατανάλωση καυσίμου για μια δεδομένη απόσταση.
     * @param distance η απόσταση που θα διανύσει το όχημα (σε χιλιόμετρα)
     * @return η συνολική κατανάλωση καυσίμου
     */
    public double calculateFuelConsumption(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative.");
        }
        return distance * fuelConsumption;
    }

    /**
     * Εμφανίζει τα στοιχεία του οχήματος στην κονσόλα.
     */
    public void display() {
        System.out.println("Vehicle ID: " + id);
        System.out.println("Type: " + vehicleType);
        System.out.println("Capacity: " + capacity + " units");
        System.out.println("Fuel Consumption: " + fuelConsumption + " L/km");
    }
}
