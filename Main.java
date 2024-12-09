import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Client> clientsFromFile = DataLoader.loadClientsFromFile("clients.txt", ",");
        System.out.println("Clients' data:");
        System.out.println();
        for (Client client : clientsFromFile) {
            client.display();
            System.out.println();
        }

        DistanceMatrix distanceMatrix = DataLoader.loadDistanceMatrixFromFile("distances.txt", clientsFromFile.size() + 1, ",");
        System.out.println("Clients' distances:");
        System.out.println();
        distanceMatrix.display();
        System.out.println();

        List<Vehicle> vehicles = List.of(new Vehicle(1, 1800, "Φορτηγό", 400));

        List<Route> routes = VRPOptimizer.optimizeRoutes(clientsFromFile, vehicles, distanceMatrix);

        System.out.println("Optimized routes:");
        System.out.println();
        for (Route route : routes) {
            route.display(distanceMatrix);
            System.out.println();
        }
    }
}
