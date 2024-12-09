import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Φόρτωση δεδομένων πελατών από αρχείο (π.χ. clients.txt)
        List<Client> clientsFromFile = DataLoader.loadClientsFromFile("clients.txt", ",");
        System.out.println("Clients' data:");
        System.out.println();
        for (Client client : clientsFromFile) {
            client.display();
            System.out.println(); // Εμφάνιση στοιχείων κάθε πελάτη από το αρχείο
        }

        // Δημιουργία του πίνακα αποστάσεων από το αρχείο (π.χ. distances.txt)
        DistanceMatrix distanceMatrix = DataLoader.loadDistanceMatrixFromFile("distances.txt", clientsFromFile.size() + 1, ","); // +1 για την αποθήκη
        System.out.println("Clients' distances:");
        System.out.println();
        distanceMatrix.display();
        System.out.println(); // Εμφάνιση του πίνακα αποστάσεων

        // Δημιουργία οχημάτων με συγκεκριμένη χωρητικότητα
        List<Vehicle> vehicles = List.of(new Vehicle(1, 1800, "Φορτηγό", 400));

        // Εφαρμογή αλγορίθμου βελτιστοποίησης
        List<Route> routes = VRPOptimizer.optimizeRoutes(clientsFromFile, vehicles, distanceMatrix); // Βελτιστοποίηση διαδρομών

        // Εμφάνιση αποτελεσμάτων διαδρομών
        System.out.println("Optimized routes:");
        System.out.println();
        for (Route route : routes) {
            route.display(distanceMatrix);
            System.out.println(); // Εμφάνιση κάθε βέλτιστης διαδρομής
        }
    }
}
