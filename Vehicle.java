public class Vehicle {
    private int id;
    private double capacity;
    private String vehicleType;
    private double fuelConsumption;

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

    public double calculateFuelConsumption(double distance) {
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative.");
        }
        return distance * fuelConsumption;
    }

    public void display() {
        System.out.println("Vehicle ID: " + id);
        System.out.println("Type: " + vehicleType);
        System.out.println("Capacity: " + capacity + " units");
        System.out.println("Fuel Consumption: " + fuelConsumption + " L/km");
    }
}
