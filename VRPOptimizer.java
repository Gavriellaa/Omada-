import java.util.ArrayList;
import java.util.List;

public class VRPOptimizer {

    public static List<Route> optimizeRoutes(List<Client> clients, List<Vehicle> vehicles, DistanceMatrix distanceMatrix) {
        List<Route> routes = new ArrayList<>();

        if (clients == null || clients.isEmpty()) {
            System.err.println("No clients available to optimize routes.");
            return routes;
        }
        if (vehicles == null || vehicles.isEmpty()) {
            System.err.println("No vehicles available to optimize routes.");
            return routes;
        }

        for (Vehicle vehicle : vehicles) {
            double remainingCapacity = vehicle.getCapacity();
            Route route = new Route(vehicle);
            Client currentClient = null;

            while (!clients.isEmpty()) {
                Client nextClient = findNearestClient(currentClient, clients, distanceMatrix, remainingCapacity);
                if (nextClient == null) {
                    break;
                }

                route.addClient(nextClient);
                remainingCapacity -= nextClient.getDemand();
                clients.remove(nextClient);
                currentClient = nextClient;
            }

            routes.add(route);
        }

        return routes;
    }

    private static Client findNearestClient(Client currentClient, List<Client> clients, DistanceMatrix distanceMatrix, double remainingCapacity) {
        double minDistance = Double.MAX_VALUE;
        Client nearestClient = null;

        for (Client client : clients) {
            if (client.getDemand() > remainingCapacity) {
                continue;
            }

            double distance = currentClient == null
                    ? distanceMatrix.getDistance(0, client.getId())
                    : distanceMatrix.getDistance(currentClient.getId(), client.getId());

            if (distance < minDistance) {
                minDistance = distance;
                nearestClient = client;
            }
        }

        return nearestClient;
    }
}
