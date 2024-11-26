import java.util.ArrayList;
import java.util.List;

public class VRP {


    public static double solveVRP(List<Client> clients, DistanceMatrix distanceMatrix, int vehicleCount) {
        if (clients == null || clients.isEmpty()) {
            System.err.println("No clients provided.");
            return 0;
        }
        if (vehicleCount <= 0) {
            System.err.println("Invalid number of vehicles.");
            return 0;
        }

        int n = clients.size();
        int fullMask = (1 << n) - 1;
        double[][] dp = new double[1 << n][n];
        int[][] parent = new int[1 << n][n];


        for (int mask = 0; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                dp[mask][i] = Double.MAX_VALUE;
                parent[mask][i] = -1;
            }
        }


        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = distanceMatrix.getDistance(0, clients.get(i).getId());
        }


        for (int mask = 1; mask <= fullMask; mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue;
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue;
                    int nextMask = mask | (1 << v);
                    double newCost = dp[mask][u] + distanceMatrix.getDistance(clients.get(u).getId(), clients.get(v).getId());
                    if (dp[nextMask][v] > newCost) {
                        dp[nextMask][v] = newCost;
                        parent[nextMask][v] = u;
                    }
                }
            }
        }


        double minCost = Double.MAX_VALUE;
        int lastClient = -1;
        for (int i = 0; i < n; i++) {
            double cost = dp[fullMask][i] + distanceMatrix.getDistance(clients.get(i).getId(), 0);
            if (minCost > cost) {
                minCost = cost;
                lastClient = i;
            }
        }


        System.out.println("Βέλτιστη διαδρομή:");
        int currentMask = fullMask;
        List<Integer> route = new ArrayList<>();
        while (lastClient != -1) {
            route.add(0, lastClient);
            int temp = lastClient;
            lastClient = parent[currentMask][lastClient];
            currentMask &= ~(1 << temp);
        }
        route.forEach(clientIndex -> System.out.print("Client " + clients.get(clientIndex).getId() + " -> "));
        System.out.println("Depot");
        return minCost;
    }

    public static void main(String[] args) {

        List<Client> clients = DataLoader.loadClientsFromCSV("clients.csv", ",");
        DistanceMatrix distanceMatrix = DataLoader.loadDistanceMatrixFromCSV("distances.csv", clients.size() + 1, ",");

        int vehicleCount = 2;

        double minCost = solveVRP(clients, distanceMatrix, vehicleCount);
        System.out.println("Ελάχιστο κόστος: " + minCost);
    }
}
