public class Client {
    private int id;
    private double x;
    private double y;
    private double demand;

    public Client(int id, double x, double y, double demand) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }
        if (demand < 0) {
            throw new IllegalArgumentException("Demand cannot be negative.");
        }

        this.id = id;
        this.x = x;
        this.y = y;
        this.demand = demand;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDemand() {
        return demand;
    }

    public void setDemand(double demand) {
        if (demand < 0) {
            throw new IllegalArgumentException("Demand cannot be negative.");
        }
        this.demand = demand;
    }

    public double calculateDistance(Client other) {
        if (other == null) {
            throw new IllegalArgumentException("Other client cannot be null.");
        }
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calculateDistance(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void display() {
        System.out.println("Client ID: " + id);
        System.out.println("Coordinates: (" + x + ", " + y + ")");
        System.out.println("Demand: " + demand + " units");
    }
}
