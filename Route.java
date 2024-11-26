import java.util.List;
import java.util.ArrayList;

public class Route {
    private Vehicle vehicle;
    private List<Client> clients;

    public Route(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        if (client != null) {
            clients.add(client);
        } else {
            System.err.println("Attempted to add a null client to the route.");
        }
    }

    public List<Client> getClients() {
        return new ArrayList<>(clients);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double calculateTotalCost(DistanceMatrix distanceMatrix) {
        if (clients.isEmpty()) {
            System.err.println("No clients in route. Total cost is 0.");
            return 0;
        }
        double totalCost = 0;
        Client previousClient = null;

        for (Client client : clients) {
            if (previousClient == null) {
                totalCost += distanceMatrix.getDistance(0, client.getId());
            } else {
                totalCost += distanceMatrix.getDistance(previousClient.getId(), client.getId());
            }
            previousClient = client;
        }

        totalCost += distanceMatrix.getDistance(previousClient.getId(), 0);

        return totalCost;
    }

    public double calculateTotalDemand() {
        return clients.stream().mapToDouble(Client::getDemand).sum();
    }

    public boolean exceedsCapacity() {
        return calculateTotalDemand() > vehicle.getCapacity();
    }

    public void display(DistanceMatrix distanceMatrix) {
        System.out.println("Route for Vehicle " + vehicle.getId() + ": ");
        for (Client client : clients) {
            System.out.print("Client " + client.getId() + " -> ");
        }
        System.out.println("Depot");
        System.out.println("Total cost: " + calculateTotalCost(distanceMatrix));
        System.out.println("Total demand: " + calculateTotalDemand());
        System.out.println("Exceeds capacity: " + exceedsCapacity());
    }
}
