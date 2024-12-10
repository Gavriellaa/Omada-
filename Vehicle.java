public class Vehicle {
    private int id;
    private double capacity;
    private String vehicleType;

    public Vehicle(int id, double capacity, String vehicleType) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }

        this.id = id;
        this.capacity = capacity;
        this.vehicleType = vehicleType;
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

    public void display() {
        System.out.println("Vehicle ID: " + id);
        System.out.println("Type: " + vehicleType);
        System.out.println("Capacity: " + capacity + " units");
    }
}
