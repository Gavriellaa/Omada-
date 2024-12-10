import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public static List<Client> loadClientsFromFile(String filePath, String delimiter) {
        List<Client> clients = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values.length != 4) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }
                try {
                    int id = Integer.parseInt(values[0]);
                    int x = Integer.parseInt(values[1]);
                    int y = Integer.parseInt(values[2]);
                    int demand = Integer.parseInt(values[3]);
                    clients.add(new Client(id, x, y, demand));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        }
        return clients;
    }

    public static DistanceMatrix loadDistanceMatrixFromFile(String filePath, int size, String delimiter) {
        DistanceMatrix matrix = new DistanceMatrix(size);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values.length != 3) {
                    System.err.println("Invalid row format in line:" + line);
                    continue;
                }
                try {
                    int client_id_1 = Integer.parseInt(values[0].trim());
                    int client_id_2 = Integer.parseInt(values[1].trim());
                    double distance = Double.parseDouble(values[2].trim());

                    matrix.addDistance(client_id_1, client_id_2, distance);
                    matrix.addDistance(client_id_2, client_id_1, distance);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid format in line:" + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        }
        return matrix;
    }

    public static List<Vehicle> loadVehiclesFromFile(String filePath, String delimiter) {
        List<Vehicle> vehicles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Παράβλεψη επικεφαλίδας
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values.length != 3) { // Έλεγχος σωστής μορφής
                    System.err.println("Invalid line format: " + line);
                    continue;
                }
                try {
                    int id = Integer.parseInt(values[0]);
                    double capacity = Double.parseDouble(values[1]);
                    String vehicleType = (values[2]);
                    vehicles.add(new Vehicle(id, capacity, vehicleType));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        }
        return vehicles;
    }
}
