/**
 * Η κλάση Client αναπαριστά έναν πελάτη με συγκεκριμένες συντεταγμένες
 * και ζήτηση σε ένα δισδιάστατο επίπεδο.
 */
public class Client {
    private int id; // Το μοναδικό αναγνωριστικό του πελάτη
    private double x; // Η x-συντεταγμένη της θέσης του πελάτη
    private double y; // Η y-συντεταγμένη της θέσης του πελάτη
    private double demand; // Η ζήτηση του πελάτη σε μονάδες

    public Client(int id, double x, double y, double demand) {
        if (id < 0) {
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

    // Getters and Setters
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

    /**
     * Υπολογίζει την ευκλείδεια απόσταση από έναν άλλο πελάτη.
     * @param other ένας άλλος πελάτης
     * @return η ευκλείδεια απόσταση
     */
    public double calculateDistance(Client other) {
        if (other == null) {
            throw new IllegalArgumentException("Other client cannot be null.");
        }
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Υπολογίζει την ευκλείδεια απόσταση από ένα συγκεκριμένο σημείο.
     * @param x η x-συντεταγμένη του σημείου
     * @param y η y-συντεταγμένη του σημείου
     * @return η ευκλείδεια απόσταση
     */
    public double calculateDistance(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Εμφανίζει τις πληροφορίες του πελάτη στην κονσόλα.
     */
    public void display() {
        System.out.println("Client ID: " + id);
        System.out.println("Coordinates: (" + x + ", " + y + ")");
        System.out.println("Demand: " + demand + " units");
    }
}
